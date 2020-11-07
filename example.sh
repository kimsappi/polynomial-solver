cd src
make

declare -a INPUTS=(
  "X^2 = 0"
  "5 * X^2 = X + 7"
  "X^2 + 4 * X + 4 = 0"
  "X^2 + X + 0.25 = 0"
  "X^3 = 0"
  "X^1.5 = 0"
  "3 * X = 17"
  "X = X + 5"
  "4 * X^2 + 18 * X = 4 * X^2 + 18 * X"
)

for input in "${INPUTS[@]}"
do
  echo "\nInput: '$input' =>"
  java com.computor.Main "$input"
done
