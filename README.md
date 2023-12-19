# numbers2words

About: This a simple clojure library that converts any positive integer between the range of 0 to 1000000000(exclusive) into proper english words.
       Passing a non positive interger or one that is one that is > 999999999 or any of different type will result to an error

## Installation
Add the library on your project.clj

[numbers2words "0.1.0-SNAPSHOT"]

## Usage

(require '[numbers2words.core :refer :all])

(get-words 156) = one hundred and fifty six


## More Examples

(get-words 3546) = three thousand five hundred and forty six

(get-words 0) = zero

(get-words 36) = thirty six

(get-words 43960943) = forty three million nine hundred and sixty thousand nine hundred and forty three

(get-words 999999999) = nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine
...

### Bugs

Incase of any bug kindly reachout georgegatuma.gg@gmail.com
...

## License

Copyright © 2021 WeFarm:GG
