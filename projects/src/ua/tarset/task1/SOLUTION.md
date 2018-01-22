# Task 1
*"There is a string of characters. It is necessary to calculate the frequency of occurrence of each character of English alphabet in this string (large and small characters count as the same)."*

The program with class `Main` and model `Letter`.

Model `Letter`. Contains letter and counter repetition in string:
```java
class Letter {
	String letter;
	int numberOfRepetitions = 0;
}
```

Variables class `Main`:
* `String STR` - target string;
* `int numberOfLetters` - counter letters in target string;
* `Map<String, Letter> letters` - collection letters;
* `SortedSet<String> keyToHashLetters` - collection keys to collection letters.

#### Algorithm:
```java
for (char symbol: STR.toCharArray())
    if (symbol >= 'A' && symbol <= 'z') //select only latin letters
```
```java
numberOfLetters++; //increments count letters in target string
```
```java
//if need - remodel characters in small
String letter = symbol < 'a' ? String.valueOf((char) (symbol + 32)) : String.valueOf(symbol);
```
```java
//if such a letter is already included in the collection, then we increase its counter
if (letters.get(letter) != null) letters.get(letter).numberOfRepetitions++;
else { //otherwise creating model a letter and put it into a collection
	keyToHashLetters.add(letter); //save key
	Letter clsLetter = new Letter();
	clsLetter.letter = letter;
	clsLetter.numberOfRepetitions++;
	letters.put(letter, clsLetter);
}
```
And output result:
```java
for (String key: keyToHashLetters) {
	Letter letter = letters.get(key);
	System.out.println(letter.letter + ": " + ((float) letter.numberOfRepetitions * 100 / numberOfLetters) + "%");
}
```
#### Result:
```
a: 11.612904%
b: 0.6451613%
c: 9.67742%
d: 0.6451613%
e: 12.258064%
f: 3.2258065%
g: 2.580645%
h: 6.451613%
i: 5.16129%
l: 4.516129%
m: 1.2903225%
n: 5.806452%
o: 4.516129%
p: 0.6451613%
q: 0.6451613%
r: 9.032258%
s: 8.387096%
t: 9.032258%
u: 2.580645%
y: 1.2903225%
```
