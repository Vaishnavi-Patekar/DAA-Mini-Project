# 🧩 String Matching Algorithm Comparison — Naive vs Rabin-Karp

## 📘 Project Overview
This mini-project is developed as part of the **Design and Analysis of Algorithms (DAA)** course.  
It demonstrates and compares the performance of two string matching algorithms:
1. **Naive String Matching Algorithm**
2. **Rabin–Karp Algorithm**

Both algorithms are implemented in **Java**, and their execution times are measured to analyze performance differences for the same input text and pattern.

---

## 🎯 Objective
- To understand the working principles of pattern matching algorithms.  
- To compare **time complexity** and **execution time** between Naive and Rabin–Karp approaches.  
- To observe how hashing improves search efficiency in Rabin–Karp.

---

## ⚙️ Features
- Takes **user input** for text and pattern.  
- Implements both **Naive** and **Rabin–Karp** algorithms.  
- Displays **matching indices** where the pattern is found.  
- Measures and compares **execution time** of both algorithms.  
- Outputs clear performance results.

---

## 🧠 Algorithms Used

### 1️⃣ Naive String Matching
- Checks for the pattern at every position in the text.
- Compares substring character by character.
- **Time Complexity:** O((n–m+1) × m)

### 2️⃣ Rabin–Karp Algorithm
- Uses **hashing** to speed up comparisons.
- Compares hash values of pattern and substrings of text.
- If hashes match, verifies actual substring.
- **Average Time Complexity:** O(n + m)  
- **Worst Case:** O(n × m)

---

## 🧰 Technologies Used
- **Language:** Java   
- **IDE:**  VS Code  
- **Concepts:** String Processing, Hashing, Algorithm Analysis, Time Measurement

---




