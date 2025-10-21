# Advanced Java Exception Handling - Refactored Solutions

**Tugas Praktikum PBO - Week 9**  
**Senior Software Engineering Approach to Exception Handling**

---

## 📋 Overview

Repository ini berisi implementasi *refactored* dari tiga kasus penanganan eksepsi Java, dirancang dengan praktik terbaik dalam defensive programming dan robust error handling.

---

## 🎯 Learning Objectives

1. **Preventive Exception Handling** - Mencegah eksepsi sebelum terjadi melalui validasi
2. **Graceful Degradation** - Program tetap berjalan meski ada error
3. **User-Centric Error Messages** - Feedback yang jelas dan actionable
4. **Separation of Concerns** - Business logic vs UI error handling
5. **Production-Ready Code** - Kode yang robust untuk dunia nyata

---

## 📁 Project Structure

```
FolderTugas9/
├── src/
│   ├── case1/
│   │   └── CountLetters.java      # Character frequency counter with validation
│   ├── case2/
│   │   └── ParseInts.java         # Integer sum extractor from mixed text
│   └── case3/
│       ├── MathUtils.java         # Factorial utility with constraints
│       └── Factorials.java        # Interactive factorial calculator
└── README.md
```

---

## 🔧 Case 1: CountLetters - Resilient Character Counter

### Problem
Program original crash dengan `ArrayIndexOutOfBoundsException` ketika input mengandung karakter non-alfabet.

### Solution Approach
- **Preventive Validation**: Cek setiap karakter sebelum akses array
- **User Feedback**: Laporkan semua karakter invalid yang ditemukan
- **Graceful Continue**: Proses tetap berlanjut, skip karakter invalid

### Key Improvements
```java
// Before: Crash on special characters
counts[word.charAt(i)-'A']++;  // ⚠️ Boom if '!' or '5'

// After: Validate first
if (Character.isLetter(currentChar) && currentChar >= 'A' && currentChar <= 'Z') {
    counts[currentChar - 'A']++;  // ✅ Safe
} else {
    // Collect and report invalid characters
}
```

### Running Case 1
```bash
cd src/case1
javac CountLetters.java
java CountLetters
```

**Test Inputs:**
- `Hello123` → Reports '1', '2', '3' as invalid
- `Java!@#` → Reports '!', '@', '#' as invalid
- `ProgrammingIsRun` → No warnings, full count

---

## 🔧 Case 2: ParseInts - Robust Integer Extractor

### Problem
Program crash dengan `NumberFormatException` pada token non-integer pertama.

### Solution Approach
- **Try-Catch Pattern**: Wrap parsing dalam exception handler
- **Silent Skip**: Lewati non-integer tanpa gangguan
- **Complete Processing**: Proses seluruh baris, bukan hanya sampai error

### Key Improvements
```java
// Before: Crashes on "hello"
val = Integer.parseInt(scanLine.next());  // ⚠️ Boom

// After: Graceful handling
try {
    int value = Integer.parseInt(token);
    sum += value;  // Only add if parseable
} catch (NumberFormatException e) {
    // Skip silently - expected behavior
}
```

### Running Case 2
```bash
cd src/case2
javac ParseInts.java
java ParseInts
```

**Test Inputs:**
- `There are 10 cats and 5 dogs` → Sum: 15
- `Price: 100 dollars minus 20 discount` → Sum: 80
- `No numbers here!` → Sum: 0

---

## 🔧 Case 3: Factorials - Multi-Layer Error Handling

### Problem
1. `MathUtils.factorial()` tidak validasi input (bug untuk negatif & overflow)
2. `Factorials.java` tidak handle eksepsi dari utility

### Solution Approach - Two-Tier Architecture

#### Tier 1: MathUtils.java (Business Logic)
- **Fail-Fast Validation**: Throw exceptions untuk input invalid
- **Mathematical Constraints**: Reject negative, prevent overflow
- **Clear Contracts**: Exception messages sebagai dokumentasi

```java
// Mathematical constraint enforcement
if (n < 0) {
    throw new IllegalArgumentException("Factorial undefined for negatives");
}
if (n > 16) {
    throw new IllegalArgumentException("Overflow risk: max input is 16");
}
```

#### Tier 2: Factorials.java (UI Layer)
- **Multi-Exception Handling**: Handle berbagai jenis error
- **Loop Continuation**: Program tetap jalan setelah error
- **Scanner Buffer Management**: Prevent infinite loops

```java
try {
    int val = scan.nextInt();  // May throw InputMismatchException
    int result = MathUtils.factorial(val);  // May throw IllegalArgumentException
    System.out.println("Result: " + result);
} catch (IllegalArgumentException e) {
    // Business logic error - show specific message
} catch (InputMismatchException e) {
    // Invalid input type - clear buffer and continue
    scan.nextLine();
}
```

### Running Case 3
```bash
cd src/case3
javac MathUtils.java Factorials.java
java Factorials
```

**Test Scenarios:**
- Input `5` → Success: `120`
- Input `-3` → Error: "Factorial not defined for negative numbers"
- Input `20` → Error: "Exceeds maximum value (16)"
- Input `abc` → Error: "Invalid input type"

---

## 🎓 Software Engineering Principles Applied

### 1. **Defensive Programming**
- Validate all inputs before processing
- Never trust user data
- Anticipate and handle edge cases

### 2. **Fail-Safe Design**
- Program continues under error conditions
- No unexpected crashes
- Graceful degradation of functionality

### 3. **Separation of Concerns**
- Business logic validates and throws
- UI layer catches and displays
- Clear responsibility boundaries

### 4. **User-Centric Design**
- Specific, actionable error messages
- No technical jargon in user-facing text
- Guidance on how to correct errors

### 5. **Maintainability**
- Extensive inline documentation
- Code review comments explain "why"
- Self-documenting exception messages

---

## 📊 Exception Handling Decision Matrix

| Scenario | Exception Type | Handling Strategy | Rationale |
|----------|---------------|-------------------|-----------|
| **Non-alphabet char** | None (prevented) | Pre-validation | More efficient than try-catch |
| **Non-integer token** | NumberFormatException | Catch & skip | Expected in mixed content |
| **Negative factorial** | IllegalArgumentException | Throw from util | Mathematical constraint |
| **Overflow risk** | IllegalArgumentException | Throw from util | Data type limitation |
| **Invalid input type** | InputMismatchException | Catch & retry | User error, recoverable |

---

## 🚀 Compilation & Testing

### Compile All Cases
```bash
# From project root
javac src/case1/*.java
javac src/case2/*.java
javac src/case3/*.java
```

### Run Complete Test Suite
```bash
# Case 1 Tests
echo "Test123" | java -cp src case1.CountLetters

# Case 2 Tests
echo "10 apples and 5 oranges" | java -cp src case2.ParseInts

# Case 3 Tests (interactive)
java -cp src case3.Factorials
```

---

## 💡 Key Takeaways

### When to Use Try-Catch
✅ **Use when:**
- Exception is expected and part of normal flow (e.g., parsing)
- External input validation (user input, file I/O)
- Calling methods that declare checked exceptions

❌ **Don't use when:**
- Can be prevented with simple validation
- Would hide programming errors
- Used for control flow in internal logic

### Exception Best Practices Demonstrated

1. **Specific Exceptions**: `IllegalArgumentException` > generic `Exception`
2. **Descriptive Messages**: Include what, why, and how to fix
3. **Appropriate Scope**: Try-catch only around risky code
4. **Resource Cleanup**: Always close Scanner/resources
5. **Don't Swallow**: Never catch without action (log/report/handle)

---

## 📚 References & Further Reading

- Oracle Java Tutorials: Exception Handling
- Effective Java (Joshua Bloch) - Items 69-77
- Clean Code (Robert Martin) - Chapter 7: Error Handling

---

## 👨‍💻 Author

**Refactored for PBO Course - Politeknik Negeri Bandung**  
*Demonstrating senior-level exception handling practices*

---

## 📝 License

Educational use only - Politeknik Negeri Bandung Academic Exercise

---

**💻 Happy Coding & Handle Those Exceptions Like a Pro! 🚀**
