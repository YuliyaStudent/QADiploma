##Отчет по итогам автоматизации

Было запланировано проведение 76 тестов, все они проведены. В ходе тестирования было добавлено еще 4 теста, упущенных при написания плана по тестированию.
####Сработавшие риски:
- отсутствие документации (двусмысленность оценки является ли найденная нелогичность приложения багом или мелким недочетом)
- использование Docker в условиях наличия только минимальных системных требований (в ходе тестирования из-за устаревшего оборудования оно было заменено с последующей настройкой всех необходимых для тестирования инструментов заново)
- отсутствие тестирования с использованием реальных тестовых данных (невозможность проверки реальной оплаты тура, в связи с этим практически бесполезные тесты на граничные значения (в случаях +1) в полях "CVC/CVV", "номер карты")
- недостаточный опыт тестировщика (было потрачено много времени на изучение дополнил тельных материалов)

Все риски, описанные в плане по тестированию сработали. Дополнительных рисков не возникло. Планирование тестирования было проведено успешно.

####Общий итог затраченного времени:
1. план автоматизации - 12 часов 56 минут (план дорабатывался по рекомендациям дипломного руководителя)
2. создание проекта и его подготовка к автотестам (подключение плагинов, зависимостей, создание PageObject'ов) - 7 часов
3. написание автотестов - 10 часов 15 минут;
4. составление баг-репортов -  4 часа;
5. составление отчета по результатам тестирования - 1 час 15 минут;
6. решение непредвиденных сложностей -  12 часов;

Общее потраченное время: 47 часов 26 минут, что гораздо меньше запланированного времени, однако из-за смены оборудования и его последующей настройки, настройки инструментов тестирования заново, сроки выдержаны не были.


