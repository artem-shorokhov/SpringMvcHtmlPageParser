# SpringMvcHtmlPageParser
Spring MVC HTML-page parser

This cute webapp's purpose is to parse HTML-page located by specified URL in search of alphabetical words.
It counts and shows total number of words on the page and number of unique words on the page,
and forms and shows sorted list of unique words and their occurrences.

In addition to original task it is implemented as webapp, and shows number of unique words on the page.

Original task in russian:
<pre>
Требуется написать Java программу которая соответсвует следующим требованиям:

1. С команднои строки пользователь может запустить программу и передать аргументом URL какой либо страницы на интернете.
2. Принимаются только HTTP:// URL. В случае если пользователь ввел какой либо другой URL, программа должна репортировать ошибку.
3. Программа должна убедится что вернувшаяся страница имеет именно HTML содержание. Если нет, то необходимо вывести ошибку в формате: «Данный URL – http://хххххх - не содержит HTML содержания», где 'http://xxxxx’ должен быть предоставленный адрес.
4. Для загруженной страницы программа должна предоставить следующий отчет:
	• общее количество слов;
	• отсортированный список слов с числом повторений каждого из слов на странице.
5. «Слова» и символы которые содержат цифры или знаки пунктуации следует игнорировать.
6. Основным признаком разделения слов служат следующие символы: пробел, точка, запятая, точка с запятой, тире и перенос каретки. Дополнительными плюсами в Вашем решении и алгоритме будет являтся выполнение следующих условий (это не является необходимыми требованиями, но при включении в решение, Вы заработаете дополнительные «очки»). Слова которые являются HTML тэгами следует игнорировать. Следует игнорировать содержание таких тэгов как <style>, <script>, <image>, <object>.

Решение будет оцениваться по следующим критериям:

1. Оригинальность решения.
2. Скорость выполнения программы.
3. Элегантность в решении.
4. Использование ООП.
5. Читабельность кода, понятные наименования переменных и методов.
6. Отсутствие зависимостей от внешних библиотек.
</pre>
