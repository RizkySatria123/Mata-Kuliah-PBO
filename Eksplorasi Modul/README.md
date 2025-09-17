# PBO Inheritance Exercises

## Struktur Tugas
```
src/
  task1/
    Circle.java
    Cylinder.java
    Task1Demo.java
  task2/
    Shape.java
    CircleShape.java
    Rectangle.java
    Square.java
    Task2Demo.java
  task3/
    Payable.java
    WorkLog.java
    Trainable.java
    PersonBase.java
    Employee.java
    Manager.java
    Trainer.java
    Task3Demo.java
```

## Konsep yang Ditunjukkan
- Inheritance dasar (`Circle` -> `Cylinder`)
- Constructor chaining dengan `super(...)`
- Method overriding (`toString()`, `computePay()`, dll.)
- Abstract superclass (`Shape`) dan polymorphism runtime
- Menjaga invariant di subclass (`Square` menimpa setter)
- Multiple inheritance gaya Java melalui banyak interface (`Employee implements Payable, WorkLog, Trainable`)
- Penggunaan `super.methodName()` untuk augment perilaku (`Manager.computePay()`)

## Cara Kompilasi (Windows PowerShell)
Dari root folder yang berisi `src` jalankan:
```powershell
# Kompilasi semua
javac -d out $(Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })

# Jalankan demo Task 1
java -cp out task1.Task1Demo

# Jalankan demo Task 2
java -cp out task2.Task2Demo

# Jalankan demo Task 3
java -cp out task3.Task3Demo
```
Jika `Get-ChildItem` tidak bekerja (versi PowerShell berbeda), bisa manual:
```powershell
javac -d out src/task1/*.java src/task2/*.java src/task3/*.java
```

## Catatan Edge Case
- Radius / height / width / length negatif melempar `IllegalArgumentException`.
- Setter menjaga invariant `Square` (width == length).
- Bonus / hourlyRate / hours negatif ditolak.
- Null string (color/name/topic) diganti default.

## Polymorphism Contoh
- `Circle poly = new Cylinder(...);` memanggil `Cylinder.toString()`.
- Array `Shape[]` berisi `CircleShape`, `Rectangle`, `Square` memicu dynamic dispatch `getArea()`.
- Interface array `Payable[]` berisi `Employee`, `Manager`, `Trainer` -> panggil `computePay()` masing-masing.

## Modifikasi Lanjutan (Opsional)
- Tambah interface `Measurable` untuk area/perimeter.
- Tambah logging atau unit test JUnit.
- Gunakan Maven/Gradle bila perlu struktur proyek lebih besar.

Selamat belajar! Silakan sesuaikan domain bila diperlukan.
