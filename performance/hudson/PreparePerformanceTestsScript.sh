#!bash -x

# DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
#
# Copyright 2011, 2016 Oracle and/or its affiliates. All rights reserved.
#
# Oracle and Java are registered trademarks of Oracle and/or its affiliates.
# Other names may be trademarks of their respective owners.
#
# The contents of this file are subject to the terms of either the GNU
# General Public License Version 2 only ("GPL") or the Common
# Development and Distribution License("CDDL") (collectively, the
# "License"). You may not use this file except in compliance with the
# License. You can obtain a copy of the License at
# http://www.netbeans.org/cddl-gplv2.html
# or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
# specific language governing permissions and limitations under the
# License.  When distributing the software, include this License Header
# Notice in each file and include the License file at
# nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
# particular file as subject to the "Classpath" exception as provided
# by Oracle in the GPL Version 2 section of the License file that
# accompanied this code. If applicable, add the following below the
# License Header, with the fields enclosed by brackets [] replaced by
# your own identifying information:
# "Portions Copyrighted [year] [name of copyright owner]"
#
# If you wish your version of this file to be governed by only the CDDL
# or only the GPL Version 2, indicate your decision by adding
# "[Contributor] elects to include this software in this distribution
# under the [CDDL or GPL Version 2] license." If you do not indicate a
# single choice of license, a recipient has the option to distribute
# your version of this file under either the CDDL, the GPL Version 2 or
# to extend the choice of license to its licensees as provided above.
# However, if you add GPL Version 2 code and therefore, elected the GPL
# Version 2 license, then the option applies only if the new code is
# made subject to such option by the copyright holder.
#
# Contributor(s):

env
# kill all unwanted processes
case $OSTYPE in
    msdos | windows | cygwin)
        ps -efW| egrep -i "junit|netbeans|test|anagram|ant|jusched"|egrep -vi system32|awk '{print $2}'| xargs /bin/kill -f;
        ;;
    linux*)
        ps -e| egrep -i "junit|netbeans|test|anagram|ant|jusched"|egrep -vi system32|awk '{print $2}'| xargs /bin/kill -9;
        ;;
    darwin11)
        ps -e| egrep -i "junit|netbeans|test|anagram|ant|jusched"|egrep -vi system32|awk '{print $1}'| xargs /bin/kill -9;
        ;;
    *)
        jps| egrep -i "junit|netbeans|test|anagram|ant|jusched"|egrep -vi system32| xargs kill;
        ;;
esac
jps | grep JUnitTestRunner | cut -d' ' -f1 | xargs kill -9
sleep 5

echo "Deleting user and cache dirs"
touch "$HOME"/.netbeans/perfdev
touch "$HOME"/.cache/perfdev
rm -rf "$HOME"/.netbeans/perfdev
rm -rf "$HOME"/.cache/perfdev

cd "$WORKSPACE"/../../../../../
reposdir=`pwd`
reposdir=`cygpath -m $reposdir`
netbeansdir="$reposdir"/netbeans
netbeansdir=`cygpath -m $netbeansdir`

# Parse build number
filename=`ls "$reposdir"/zip`
echo "filename=$filename"
pnum=`echo $filename | sed -e "s/^.*-//" -e "s/.zip//"`
echo "pnum=$pnum"
echo -n ${pnum}>$reposdir/build.number
cp -f $reposdir/build.number $reposdir/../build.number
cp -f $reposdir/build.number $reposdir/../../build.number

# Update repository
if [ ! -d $reposdir/../ergonomics ]
then
  cd $reposdir/..
  hg clone http://hg.netbeans.org/ergonomics
fi
cd $reposdir/../ergonomics
pwd
hg pull -u
hg update -C

# Clean repository
ant clean
rm -rf nbbuild/nbproject/private
rm -rf performance/build
rm -rf performance/*/build

# Build tools and tests
ant bootstrap
ant -f libs.junit4 -Dnetbeans.dest.dir=$netbeansdir
ant -f performance -Dnetbeans.dest.dir=$netbeansdir
ant -f performance/j2se -Dnetbeans.dest.dir=$netbeansdir
ant -f performance/j2ee -Dnetbeans.dest.dir=$netbeansdir
ant -f performance/enterprise -Dnetbeans.dest.dir=$netbeansdir
ant -f performance/languages -Dnetbeans.dest.dir=$netbeansdir
ant -f performance/mobility -Dnetbeans.dest.dir=$netbeansdir
ant -f performance/web -Dnetbeans.dest.dir=$netbeansdir