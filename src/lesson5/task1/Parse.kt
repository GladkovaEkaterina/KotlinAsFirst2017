@file:Suppress("UNUSED_PARAMETER")
package lesson5.task1

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main(args: Array<String>) {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        }
        else {
            println("Прошло секунд с начала суток: $seconds")
        }
    }
    else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateStrToDigit(str: String): String {
    val parts = str.split(" ")
    if (parts.size == 3) {
        try {
            val day = parts[0].toInt()
            val month = parts[1]
            val stringBuilder = StringBuilder()
            stringBuilder.append(twoDigitStr(day))
            stringBuilder.append(when {
                month == "января" && day in 1..31 -> ".01."
                month == "февраля" && day in 1..29 -> ".02."
                month == "марта" && day in 1..30 -> ".03."
                month == "апреля" && day in 1..31 -> ".04."
                month == "мая" && day in 1..30 -> ".05."
                month == "июня" && day in 1..31 -> ".06."
                month == "июля" && day in 1..30 -> ".07."
                month == "августа" && day in 1..30 -> ".08."
                month == "сентября" && day in 1..31 -> ".09."
                month == "октября" && day in 1..30 -> ".10."
                month == "ноября" && day in 1..31 -> ".11."
                month == "декабря" && day in 1..31 -> ".12."
                else -> return ""
            })
            stringBuilder.append(parts[2])
            return stringBuilder.toString()
        } catch (e: NumberFormatException) {
            return ""
        }
    } else return ""
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateDigitToStr(digital: String): String {
    val parts = digital.split(".")
    val stringBuilder = StringBuilder()
    if (parts.size == 3) {
        try {
            val day = parts[0].toInt()
            if (!(day in 1..31)) return ""
            val month = parts[1]
            stringBuilder.append(day)
            stringBuilder.append(when (month) {
                "01" -> " января "
                "02" -> " февраля "
                "03" -> " марта "
                "04" -> " апреля "
                "05" -> " мая "
                "06" -> " июня "
                "07" -> " июля "
                "08" -> " августа "
                "09" -> " сентября "
                "10" -> " октября "
                "11" -> " ноября "
                "12" -> " декабря "
                else -> return ""
            })
            stringBuilder.append(parts[2])
        } catch (e: NumberFormatException) {
            return ""
        }
        return stringBuilder.toString()
    } else return ""
}

/**
 * Средняя
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -98 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку
 */
fun flattenPhoneNumber(phone: String): String = TODO()

/**
 * Средняя
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int = TODO()

/**
 * Сложная
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки вернуть -1.
 */
fun bestHighJump(jumps: String): Int = TODO()

/**
 * Сложная
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
enum class State {
    Plus, Minus, Digit
}
fun plusMinus(expression: String): Int {
    val parts = expression.split(" ")
    var state = State.Plus
    var result = 0
    for (elem in parts) {
        when {
            elem == "+" && state == State.Digit -> state = State.Plus
            elem == "-" && state == State.Digit -> state = State.Minus
            else -> {
                try {
                    val digit = elem.toInt()
                    when (state) {
                        State.Plus -> result += digit
                        State.Minus -> result -= digit
                        State.Digit -> throw IllegalArgumentException()
                    }
                    state = State.Digit
                } catch (e: NumberFormatException) {
                    throw IllegalArgumentException()
                }
            }
        }
    }
    return result
}

/**
 * Сложная
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int {
    val parts = str.split(" ")
    for (i in 0 until (parts.size - 1))
        if (parts[i].equals(parts[i + 1], true))
            return str.indexOf(parts[i] + " " + parts[i + 1])
    return -1
}

/**
 * Сложная
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть положительными
 */
fun mostExpensive(description: String): String {
    val parts = description.split("; ")
    var res = 0.0
    var product = ""
    for (elem in parts) {
        val parts2 = elem.split(" ")
        if (parts2.size == 2) {
            try {
                val s = parts2[1].toDouble()
                if (s >= res) {
                    res = s
                    product = parts2[0]
                }
            } catch (e: NumberFormatException) {
                return ""
            }
        } else return ""
    }
    return product
}

/**
 * Сложная
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 * Вернуть -1, если roman не является корректным римским числом
 */
fun fromRoman(roman: String): Int = TODO()

/**
 * Очень сложная
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> {
    var level1 = 0
    for (symbol in commands) {
        when (symbol) {
            '[' -> level1++
            ']' -> level1--
        }
        if (level1 < 0)
            throw IllegalArgumentException()
    }
    if (level1 != 0)
        throw IllegalArgumentException()
    var cellPosition = cells / 2
    val digits = MutableList<Int>(cells, { 0 })
    var count = 0
    var i = 0
    while (i < commands.length) {
        when {
            commands[i] == '+' -> digits[cellPosition]++
            commands[i] == '-' -> digits[cellPosition]--
            commands[i] == '<' -> cellPosition--
            commands[i] == '>' -> cellPosition++
            commands[i] == ' ' -> {
            }
            commands[i] == '[' -> {
                var wasFound = false
                var level = 1
                for (j in i + 1 until commands.length) {
                    if (commands[j] == ']') {
                        level--
                        if (level == 0) {
                            wasFound = true
                            if (digits[cellPosition] == 0)
                                i = j
                            break
                        }
                    }
                    if (commands[j] == '[')
                        level++
                }
                if (!wasFound)
                    throw IllegalArgumentException()
            }
            commands[i] == ']' -> {
                var wasFound = false
                var level = 1
                for (j in (i - 1) downTo 0) {
                    if (commands[j] == '[') {
                        level--
                        if (level == 0) {
                            wasFound = true
                            if (digits[cellPosition] != 0)
                                i = j
                            break
                        }
                    }
                    if (commands[j] == ']')
                        level++
                }
                if (!wasFound)
                    throw IllegalArgumentException()
            }
            else -> throw IllegalArgumentException()
        }
        if (cellPosition >= cells || cellPosition < 0)
            throw IllegalStateException()
        count++
        i++
        if (count == limit)
            break
    }
    return digits
}

