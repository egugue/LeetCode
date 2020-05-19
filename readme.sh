#!/usr/bin/env sh

set -eu

git_root_dir=$(git rev-parse --show-superproject-working-tree --show-toplevel | head -1)

collect_java_solutions() {
  echo ""
  echo "collect java solutions..."
  prev_dir=$(pwd)

  cd "$git_root_dir/jvm/"
  command ./gradlew shadowJar
  command java -jar "./build/libs/solutions.jar" src/main/java/ > "$git_root_dir/tools/readme/assets/solutions/java.json"

  cd "$prev_dir"
  echo "finish"
}

collect_ptyhon3_solutions() {
  echo ""
  echo "collect python3 solutions..."

  prev_dir=$(pwd)

  cd "$git_root_dir/python/"
  command pipenv install
  command pipenv run solutions > "$git_root_dir/tools/readme/assets/solutions/python3.json"

  cd "$prev_dir"
  echo "finish"
}

write_readme() {
  echo ""
  echo "write readme..."

  prev_dir=$(pwd)

  cd "$git_root_dir/tools/readme"
  command go build -o readme main.go
  command ./readme

  cd "$prev_dir"
  echo "finish"
}



#
# main
#

flagJava=0
flagPython3=0
flagReadme=0

if [ "$#" = 0 ]; then
  flagJava=1
  flagPython3=1
  flagReadme=1
else
  for OPT in "$@"; do
    case $OPT in
    -java)
      flagJava=1
      ;;
    -python3)
      flagPython3=1
      ;;
    -readme)
      flagReadme=1
      ;;
    *)
      echo "Error: Unexpected option $OPT"
      exit 1
      ;;
    esac
    shift
  done
fi

if [ $flagJava = 1 ]; then
  collect_java_solutions
fi

if [ $flagPython3 = 1 ]; then
  collect_ptyhon3_solutions
fi

if [ $flagReadme = 1 ]; then
  write_readme
fi

command echo ""
command echo "~~~all finished~~~"
