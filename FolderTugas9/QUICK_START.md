# 🚀 Quick Start Guide

## Get Started in 5 Minutes!

Panduan cepat untuk langsung menggunakan Advanced Java Exception Handling Lab.

---

## ⚡ Fast Track (30 seconds)

```bash
# 1. Navigate to project
cd "c:\Users\lenovo\OneDrive - Politeknik Negeri Bandung\Documents\rizky satria\Kampus Polban\Mata-Kuliah-PBO\FolderTugas9"

# 2. Run the interactive menu
run.bat

# 3. Choose a case (1, 2, or 3) and test!
```

✅ **Done!** You're now testing exception handling code.

---

## 📚 Learning Track (5 minutes)

### Step 1: Understand What You're Learning (1 min)
- **Goal:** Master exception handling in Java
- **Method:** Refactor 3 programs with different strategies
- **Outcome:** Production-ready, crash-proof code

### Step 2: Read the Overview (2 min)
Open **[README.md](README.md)** and skim:
- Cases Overview section
- Each case explanation (just the "Your Task" part)

### Step 3: Run and Test (2 min)
```bash
run.bat
```
- Choose Case 1, enter: `Java123`
- Choose Case 2, enter: `There are 10 cats and 5 dogs`
- Choose Case 3, enter: `-5` (then `5`)

---

## 🎯 By Role/Goal

### "I Just Want to Run It"
```bash
run.bat              # Windows CMD
# OR
.\run.ps1           # PowerShell
```
Choose option 1, 2, or 3. Follow prompts.

---

### "I Want to Understand Exception Handling"
1. Read: **[EXCEPTION_HANDLING_GUIDE.md](EXCEPTION_HANDLING_GUIDE.md)**
   - Focus on "Konsep Fundamental"
   - Study the Decision Tree
2. Read source code: `src/case1/CountLetters.java`
   - Read the code review comments at the top
3. Run Case 1 with different inputs
4. Repeat for Cases 2 and 3

---

### "I Need to Submit This Assignment"
1. **Compile everything:**
   ```bash
   run.bat
   ```
   Verify all cases compile successfully.

2. **Test each case:**
   - Use test inputs from **[TESTING_GUIDE.md](TESTING_GUIDE.md)**
   - Verify outputs match expected results

3. **Read the analysis:**
   - Open **[SUMMARY.md](SUMMARY.md)**
   - Understand each case's approach
   - Be ready to explain your code

4. **Submission checklist:**
   - [ ] All `.java` files
   - [ ] README.md (documentation)
   - [ ] SUMMARY.md (analysis report)
   - [ ] Can explain each exception handling strategy

---

### "I Want to Ace the Exam/Interview"
1. **Master the concepts:**
   - Read **[EXCEPTION_HANDLING_GUIDE.md](EXCEPTION_HANDLING_GUIDE.md)** completely
   - Focus on "Best Practices" section

2. **Study the code architecture:**
   - Case 1: Prevention pattern
   - Case 2: Try-parse pattern
   - Case 3: Multi-layer pattern
   - Read **[VISUAL_DIAGRAMS.md](VISUAL_DIAGRAMS.md)** for flow diagrams

3. **Practice explaining:**
   - Why did we choose prevention in Case 1?
   - When is try-catch appropriate? (Case 2)
   - What is separation of concerns? (Case 3)

4. **Test your knowledge:**
   - Can you identify which exception strategy to use for a new problem?
   - Can you write descriptive exception messages?
   - Can you explain checked vs unchecked exceptions?

---

## 📋 Common Tasks

### Compile a Specific Case
```bash
# Case 1
cd src\case1
javac CountLetters.java
java CountLetters

# Case 2
cd src\case2
javac ParseInts.java
java ParseInts

# Case 3
cd src\case3
javac MathUtils.java Factorials.java
java Factorials
```

### Re-compile After Editing
```bash
# Same as above, just re-run javac
javac YourFile.java
```

### Run Without Menu
```bash
cd src\case1
java CountLetters
# Then type your input when prompted
```

---

## 🔍 Quick Reference

### Case 1: CountLetters
- **Input:** Any string
- **Test:** `Java123`
- **Expected:** Counts J, A, V, A and warns about 1, 2, 3
- **Concept:** Preventive validation

### Case 2: ParseInts
- **Input:** Mixed text and numbers
- **Test:** `There are 10 cats and 5 dogs`
- **Expected:** Sum = 15
- **Concept:** Try-parse pattern

### Case 3: Factorials
- **Input:** Integer (or invalid input)
- **Test:** Try `5`, then `-3`, then `abc`
- **Expected:** 
  - `5` → 120
  - `-3` → Error message
  - `abc` → Error message, retry
- **Concept:** Multi-layer exception handling

---

## ❓ Troubleshooting

### "javac is not recognized"
**Problem:** Java not in PATH

**Solution:**
1. Install JDK if not installed
2. Add to PATH:
   - Windows Search → "Environment Variables"
   - Edit PATH, add: `C:\Program Files\Java\jdk-XX\bin`
3. Restart terminal

### "Package does not match expected"
**Problem:** Running from wrong directory

**Solution:**
```bash
# Always run from the case directory
cd src\case1
java CountLetters

# NOT from src/ or project root
```

### "File not found"
**Problem:** Wrong directory

**Solution:**
```bash
# Check where you are
pwd

# Should be in FolderTugas9 to run scripts
cd "c:\Users\lenovo\OneDrive - Politeknik Negeri Bandung\Documents\rizky satria\Kampus Polban\Mata-Kuliah-PBO\FolderTugas9"
```

### "Program keeps asking for input"
**Problem:** Infinite loop due to bad input in Case 3

**Solution:**
- Press `Ctrl+C` to stop
- Re-run and enter valid input
- For "Another factorial?", type `n` to exit

---

## 📖 Documentation Files Quick Guide

| When you need... | Read this file... |
|-----------------|-------------------|
| Quick overview | **README.md** |
| Test scenarios | **TESTING_GUIDE.md** |
| Learn concepts | **EXCEPTION_HANDLING_GUIDE.md** |
| Full analysis | **SUMMARY.md** |
| Visual diagrams | **VISUAL_DIAGRAMS.md** |
| Navigate project | **INDEX.md** |
| This guide | **QUICK_START.md** (you are here!) |

---

## 🎯 Success Criteria

You've successfully completed this lab when you can:

- [ ] Run all three cases without errors
- [ ] Explain why Case 1 uses prevention instead of try-catch
- [ ] Explain why Case 2 uses try-catch
- [ ] Explain the two-layer architecture in Case 3
- [ ] Write a descriptive exception message
- [ ] Identify when to use checked vs unchecked exceptions
- [ ] Make a program continue after an exception (recovery)

---

## 💡 Pro Tips

### Tip 1: Read Code Review Comments
Every `.java` file has extensive comments at the top explaining:
- What was changed
- Why it was changed
- What exception handling strategy was used

### Tip 2: Test Edge Cases
Don't just test happy path! Try:
- Empty input
- Special characters
- Very large numbers
- Negative numbers
- Non-numeric input where numbers expected

### Tip 3: Use the Visual Diagrams
If you're a visual learner, **[VISUAL_DIAGRAMS.md](VISUAL_DIAGRAMS.md)** has:
- Flow diagrams for each case
- Architecture visualization
- Comparison matrices

### Tip 4: Follow the Testing Guide
**[TESTING_GUIDE.md](TESTING_GUIDE.md)** has specific test cases with expected outputs. Use them to verify your understanding.

---

## 🚀 Next Steps

After completing this quick start:

### For Deeper Learning:
1. Read **[EXCEPTION_HANDLING_GUIDE.md](EXCEPTION_HANDLING_GUIDE.md)**
2. Study each case's source code in detail
3. Try modifying the code (add features, change behavior)

### For Assignment Submission:
1. Ensure all cases compile and run
2. Read **[SUMMARY.md](SUMMARY.md)** for complete analysis
3. Be ready to explain your design decisions

### For Interview Prep:
1. Practice explaining each pattern
2. Compare and contrast the three approaches
3. Be ready to write similar code from scratch

---

## 📞 Need More Help?

- **General questions:** See **[README.md](README.md)**
- **Testing issues:** See **[TESTING_GUIDE.md](TESTING_GUIDE.md)**
- **Concepts unclear:** See **[EXCEPTION_HANDLING_GUIDE.md](EXCEPTION_HANDLING_GUIDE.md)**
- **Want full details:** See **[SUMMARY.md](SUMMARY.md)**
- **Lost in project:** See **[INDEX.md](INDEX.md)**

---

## ⏱️ Time Estimates

| Task | Time Required |
|------|---------------|
| Just run the programs | 2 minutes |
| Understand one case | 10 minutes |
| Understand all cases | 30 minutes |
| Master exception handling concepts | 1-2 hours |
| Read all documentation | 2-3 hours |
| Become expert-level | Practice! |

---

**🎯 You're all set!**

**Start with:** `run.bat` and choose a case to test.

**Questions?** Check the relevant documentation file from the table above.

---

**Good luck and happy coding! 🚀**

*Politeknik Negeri Bandung - PBO Week 9*
