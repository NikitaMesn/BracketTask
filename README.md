# BracketTask

Ввод - input.txt
Вывод - стандартный вывод или output.txt

Дана скобочная последовательность. Нужно определить, правильная ли она.

## Будем придерживаться такого определения:

    - пустая строка — правильная скобочная последовательность;
    - правильная скобочная последовательность, взятая в скобки одного типа, — правильная скобочная последовательность;
    - правильная скобочная последовательность с приписанной слева или справа правильной скобочной последовательностью — тоже правильная.
На вход подается последовательность из скобок трёх видов: [], (), {}.
Напишите функцию isCorrectBracketSeq, которая принимает на вход скобочную последовательность и возвращает True, если последовательность правильная, иначе False.

Формат ввода

На вход подается одна строка, содержащая скобочную последовательность.

Реализация на Java 11

