# Сценарии

Страничка для описания различных моделей поведения бота

Попробую с простых сценариев, постепенно усложняя существующие, выделяя некоторые модели поведения в переиспользуемые функции высшего порядка

Итак начнем:

### рандомные вбросы (thoughts)

содержание:
- я сегодня одну позу попробовал но не знаю как называется - подскажите (стикер, ссылка на игру)
- эх, хорошо позанимались, я наблюдал, <имя кто был на занятии> сегодня
    - хорошо себя показал
    - недотянул
    - был на высоте!
    - ...
- люблю йогу) особенно нашу
- завтра йога или бунт! (если завтра занятие по расписанию)
- всем намасте! (стикер)


идеи:
- один вброс только 1 раз в принципе или раз в месяц (конфигурируемо)
- вбросы только для мейн чата
- придумать как можно больше
- у каждого вброса есть много вариантов чтобы если он повторялся - было не скучно
- бросить кубик на вброс, после броска можно еще разные решения принимать
- хранить дата-вброс в json файле чтобы не забыть

время:
- произвольно в течение дня (с 10 до 21 часа)
- только 1 раз в день


### ответ на сообщения (reactions)

сценарии:
- я за
    - и я за)
    - (стикер с согласием)
    - а я пас
- (фотография)
    - круто! запомню (сохранить фото)
    - ух ты, (это надо в наш архив)
    - прикольно) забахаю потом коллаж в конце месяца!
    - интересненько
- (если ни одного сообщения за 1 день)
    - и что молчим?)
- чатуганга (любая другая)
    - а я знаю такую (стикер)
    - вот она (стикер)
- *спать*
    - а я то как люблю поспать
- кого-то добавили в чат
    - привет новый атмаёжик!

идеи:
- у каждой реакции есть конфиг на время респонса, например "я за" - 2 секунды
- у каждой реакции есть вероятность (конфиг), например "я за" будет скажем 50%, а у фото - 30%
- хранить реакции наверное не надо, вероятность сгладит углы прямолинейности

время:
- при получении сообщения в общий чат


### карма

У каждого юзера появляется карма

Карму можно получать разными способами, например присутствие на занятии дает +1 к карме

Также +1 дается за запись в журнале тренировок

+1 можно получить случайно как рандомный вброс - просто так

+3, +2 и +1 получают самые активные пользователи за месяц

+1 получает тот кто скинул картинку

### просто идеи

- подбадривающие сообщения после +- еженедельной статистики "сл. неделя будет круче!" "молодцы, на этой неделе на 3 человека больше чем на предыдущей!"
