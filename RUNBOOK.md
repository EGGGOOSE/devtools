# 🚀 Runbook:

## git status
<pre>Перед push: git status clean</pre>

---

## Checkstyle
### Сценарий: запуск Checkstyle и исправление нарушений

1. **Gradle Tool Window** → `verification` → `checkstyleMain` (двойной клик).
2. Если **FAILED** — открой `build/reports/checkstyle/main.html`.
3. Для каждого нарушения:
    - запомни файл / строку / правило
    - исправь
    - перезапусти `checkstyleMain`
4. **SUCCESS** → продолжай; **FAILED** → повтори шаг 3.

---

### 🧩 Типичные проблемы

| Проблема | Причина | Решение |
|----------|---------|---------|
| Задачи `checkstyleMain` нет в Gradle Tool Window | Плагин не подключён | Добавь `id 'checkstyle'` в `plugins`, сделай **Sync** |
| `"config file not found"` | Путь к несуществующему XML | Убери `configFile` из блока `checkstyle` или проверь путь |
| Отчёт HTML пустой | Нет нарушений или задача не запускалась | Запусти `checkstyleMain` явно |
| Сборка падает с тысячами нарушений | Код написан без правил до Checkstyle | Начни с мягких правил, ужесточай постепенно |
| Сборка падает после каждого изменения | Checkstyle в `check` lifecycle | Запускай `checkstyleMain` отдельно, **не через `build`** |

---

## Checkstyle
### Сценарий: запуск Checkstyle и исправление нарушений

1. **Gradle Tool Window** → `verification` → `checkstyleMain` (двойной клик).
2. Если **FAILED** — открой `build/reports/checkstyle/main.html`.
3. Для каждого нарушения:
   - запомни файл / строку / правило
   - исправь
   - перезапусти `checkstyleMain`
4. **SUCCESS** → продолжай; **FAILED** → повтори шаг 3.

---

### 🧩 Типичные проблемы

| Проблема | Причина | Решение |
|----------|---------|---------|
| Задачи `checkstyleMain` нет в Gradle Tool Window | Плагин не подключён | Добавь `id 'checkstyle'` в `plugins`, сделай **Sync** |
| `"config file not found"` | Путь к несуществующему XML | Убери `configFile` из блока `checkstyle` или проверь путь |
| Отчёт HTML пустой | Нет нарушений или задача не запускалась | Запусти `checkstyleMain` явно |
| Сборка падает с тысячами нарушений | Код написан без правил до Checkstyle | Начни с мягких правил, ужесточай постепенно |
| Сборка падает после каждого изменения | Checkstyle в `check` lifecycle | Запускай