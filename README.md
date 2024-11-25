Программa, которая сортирует массив целых чисел в порядке возрастания. 
Размер массива заранее неизвестен (динамический массив).

Задание:
Реализовать метод sort()
Проверить работу программы:
добавить числа в массив с помощью метода add()
вызвать метод sort()
посмотреть содержимое массива с помощью метода print() 

Результат:
- метод sort() реализован в классе MergeSort и вызывается через экземпляр класса;
- для проверки работы метода программа запрашивает количество элементов массива и формирует массив случайных чисел который передается для сортировки;
- повторно создается массив случайных чисел с использованием метода add() и динамически расширяемого массива, он передается в метод sort() и после сортировки выводится на экран методом print(), реализованном через преобразование массива в stream с последующим созданием String для вывода на экран;
- добавлен тест для проверки метода sort() и нескольких сопутствующих методов;
- файл с точкой входа MergeSortMethod.

