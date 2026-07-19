# devtools — Gradle-проект для курса DVT-2

Проект демонстрирует настройку Gradle, работу с пакетами, record и юнит-тестирование.

---

## 🚀 Quick Start

### Запуск через Gradle Tool Window
1. Открой `View → Tool Windows → Gradle`
2. Разверни дерево:
   - `Tasks → application → run` — запуск приложения
   - `Tasks → verification → test` — запуск тестов
3. Дважды кликни на задачу или нажми иконку Run ▶️

### Запуск через Run Anything
- Нажми **Ctrl + Ctrl** (два раза)
- Введи:
  - `gradle run` — запуск приложения
  - `gradle test` — запуск тестов
  - `gradle build` — полная сборка проекта

### Запуск через терминал
```bash
./gradlew run
./gradlew test
./gradlew build
```

---

## Пакеты

**`ru.mentee.power`** — корневой пакет проекта.

**Зачем нужен пакет:**
- Предотвращает конфликты имён (классы с одинаковыми названиями из разных модулей не пересекаются)
- Организует код по функциональности
- Правило обратного доменного имени (`ru.mentee.power`) гарантирует глобальную уникальность

**Структура:**
```
src/
└── main/
    └── java/
        └── ru/
            └── mentee/
                └── power/
                    ├── ProgressDemo.java      # точка входа
                    └── MenteeProgress.java    # record с бизнес-логикой
src/
└── test/
    └── java/
        └── ru/
            └── mentee/
                └── power/
                    └── MenteeProgressTest.java   # JUnit-тесты
```

---

## Таблица полей (record `MenteeProgress`)

| Поле | Тип | Описание |
|------|-----|----------|
| `menteeName` | `String` | Имя студента |
| `sprintNumber` | `int` | Номер текущего спринта |
| `plannedHoursPerWeek` | `int` | Запланированное количество часов на спринт |

### Метод `readyForSprint()`
Возвращает `true`, если `plannedHoursPerWeek >= 3` (порог готовности к спринту).  
Иначе — `false`.

---

## Ссылка на урок
[DVT-2 — Gradle-проект и базовый main](https://mentee-power.xl.ru/learn/QtnU6_RY1kyRRKXrbILJ2Q/theory)


---

## Git локальный цикл

### Правило веток: feature/DVT‑X
- **master** — чистая ветка для стабильных версий (не коммитим напрямую)
- **feature/DVT‑X** — ветки под конкретные задачи (где X — номер урока)

### Локальный цикл (init → commit → branch)
```bash
# 1. Инициализация репозитория
git init

# 2. Проверка статуса
git status

# 3. Добавление файлов в staging
git add .

# 4. Коммит в master
git commit -m "Initial commit"

# 5. Создание feature-ветки
git checkout -b feature/DVT-3

# 6. Работа в ветке → коммиты
git add .
git commit -m "Добавить фичу"

# 7. Просмотр истории
git log --oneline
```

## Runbook
<pre>Перед push: git status clean</pre>