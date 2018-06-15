# Atmayoga Bot
Bot for Atmayoga


## Список команд для @BotFather

start - поприветствовать бота
help - показать подробную информацию о доступных командах
training_link - ссылка на табличку с тренировками
training_last - посмотреть последнюю тренировку
tavrik - узнать что там по таврику
activity - общая сводка по твоей активности за месяц
kotik - пасхалка


## Roadmap (features)

- статистика каждую неделю и каждый месяц: каждую неделю посчитать сколько людей было (+/- по сравнению с предыдущей неделей); месяц - топ-3 самых-самых по разным критериям, возможно какие-то призы от Жени
- сообщения-тизеры. т.е. придумать формат какую стату кому выдавать, когда и как часто, какими словами (стикерами)
- подумать как улучшить таврик - например научиться понимать когда был таврик и как это связано с погодой - адаптивный алгоритм вроде "в прошлый раз была такая же погода - не ходили - может и щас не стоит"
- сообщения только для Жени: например среднее кол-во посещений или категории людей: те что приходили 1 раз, 1 раз в месяц или часто; возможно предсказание кол-ва людей учитывая статистику
- игра угадай асану с плюсом в активность (карму); возможно "плюс в карму" - хороший гейм-момент и стоит его развить
- изменения расписания и оповещения об этом (договориться с Женей как)
- автоматическое добавление в таблицу при регистрации в боте
- складировать все фотографии, завести фото-коллаж по окончанию месяца
- анализ сообщений группы - поиск ключевых слов - автоответы или замечания
- go pro studio / quick, проверить как делать коллажи

## Technical Roadmap

- частичное совпадение подстроки при поиске стикера с асаной (реакция)
- любое обращение к @atmayogabot в сообщении может стриггировать разнообразную реакцию или вброс (возможно сделать реакцию которая триггирует вброс)