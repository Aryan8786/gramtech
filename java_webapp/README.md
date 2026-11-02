# RuralRise / GramTech — Java Web Edition
## Technology Support for Rural Startups
### College CEP (Community Engagement Project) Academic Prototype

---

## 🌟 Executive Summary

**RuralRise / GramTech** is an educational web application prototype built specifically for a college CEP project on the topic:
> **"Technology Support for Rural Startups"**

The application equips rural entrepreneurs, women-led Self-Help Groups (SHGs), traditional craftspeople, and smallholder farmers with practical, non-technical digital skills, viable rural enterprise blueprints, government support scheme guidance, and interactive financial calculators.

---

## ⚙️ Architecture & Technical Stack

- **Zero External JAR Dependencies:** Developed in pure Standard Java (Java 21/25) using the built-in `com.sun.net.httpserver.HttpServer`.
- **Backend Business Logic:**
  - [`logic.CalculatorLogic`](file:///d:/CJ/Rural%20Start/java_webapp/logic/CalculatorLogic.java): Financial formulas for unit profit margin, loan compound interest EMI, and monthly savings rate.
  - [`logic.GramTechData`](file:///d:/CJ/Rural%20Start/java_webapp/logic/GramTechData.java): Central in-memory repository of learning modules, business blueprints, digital tool stacks, government schemes, and success case studies.
  - [`GramTechServer`](file:///d:/CJ/Rural%20Start/java_webapp/GramTechServer.java): Embedded HTTP server with automatic port binding, CORS handling, static asset serving, and JSON REST API handlers.
- **Frontend Presentation:**
  - Modern Semantic HTML5 & Responsive CSS3 (Material 3 inspired design with a natural Forest Green `#1B5E20` & Warm Amber `#FF8F00` theme).
  - Vanilla ES6 JavaScript (`app.js`) handling dynamic rendering, real-time search, category filtering, accessible modals, and dual view mode switching.
- **Persistence:** 100% in-memory static data for immediate demonstration without database installation or network dependencies.

---

## 🚀 How to Run the Application

### Option 1: 1-Click Windows Launcher (Easiest)
Simply double-click:
```
d:\CJ\Rural Start\run_java_webapp.bat
```
*(Or `java_webapp\run_web_app.bat`)*

This script automatically:
1. Detects your Java JDK compiler (`javac`) and runtime (`java`).
2. Compiles the Java backend into the `bin/` directory.
3. Launches the web server on `http://localhost:8080`.
4. Automatically opens your default browser to `http://localhost:8080`.

---

### Option 2: Command Line (Manual)
From the `java_webapp` folder:
```powershell
# 1. Compile Java source files
javac -encoding UTF-8 -d bin logic\CalculatorLogic.java logic\GramTechData.java GramTechServer.java

# 2. Run the server
java -cp bin GramTechServer 8080
```
Open your browser and navigate to:
```
http://localhost:8080
```

---

## 📱 Dual View Mode (College Presentation Highlight)

On the top navigation bar, click the **"📱 Phone Frame" / "🖥️ Desktop View"** toggle button:
- **Desktop Portal Mode:** Full-width dashboard with modern multi-column card grids, optimized for presentations on projectors and laptop screens.
- **Smartphone Mockup Frame Mode:** Interactive smartphone frame with a simulated notch speaker, rounded bezel, drop shadow, and sticky bottom navigation bar, demonstrating how the app looks on mobile devices.

---

## 📑 Core Screens & Features

1. **Home Screen (`#screen-home`):**
   - Hero banner with key focus areas and action buttons.
   - Quick statistics strip (12+ Guides, 8 Business Models, 6 Govt Schemes).
   - Core functional highlights and inspiring mission statement.

2. **Learning Resources (`#screen-resources`):**
   - 12 comprehensive startup guides (Business basics, costing, customer interviews, digital marketing, WhatsApp catalogs, UPI safety, bookkeeping).
   - Real-time instant search bar.
   - Category filtering pills (*All Topics*, *Business Basics*, *Digital Skills*, *Financial Awareness*, *Govt Schemes*).
   - Interactive pop-up modal to read complete guides.

3. **Rural Business Ideas (`#screen-ideas`):**
   - 8 tested rural enterprise models:
     - Organic Farming & Direct Sales
     - Food Processing & Pickles
     - Handicrafts & Artisanal Decor
     - Smart Dairy Management
     - Rural Tourism & Farmstays
     - Agricultural Equipment Rental (Custom Hiring Centre)
     - Rural Courier & Last-Mile Delivery
     - Digital Village Service Center (CSC)
   - Displays capital requirements, required skills, recommended digital tools, and operational blueprints.

4. **Digital Tools Directory (`#screen-tools`):**
   - 5 practical functional pillars:
     1. Communication (WhatsApp Business, Voice & Video)
     2. Marketing (Instagram Reels, Canva, Facebook Groups)
     3. Payments (UPI QR codes, UPI Soundbox, Instant bank settlements)
     4. Productivity & Accounting (Google Sheets, Digital Khata)
     5. Continuous Learning (YouTube Tutorials, Kisan Suvidha, Skill India)

5. **Government Schemes Repository (`#screen-schemes`):**
   - 6 national programs: PM MUDRA Yojana, Startup India, Stand-Up India, PMEGP, PM Vishwakarma, and Skill India (PMKVY).
   - Outlines target beneficiaries, financial loan amounts, capital subsidies, and official portal linkouts.

6. **Real-World Success Stories (`#screen-stories`):**
   - Case studies demonstrating technology impact:
     - Satara pottery studio going online via WhatsApp & UPI.
     - Ratnagiri Alphonso mango grower direct-to-consumer sales.
     - Solapur Mahila Bachat Gat spice & pickle enterprise with PMEGP subsidy.
     - Paithan silk weavers collective using video storytelling.

7. **Financial Calculators (`#screen-calculators`):**
   - **Unit Profit Margin Calculator:** Selling price, cost price, batch quantity &rarr; Revenue, cost, net profit, margin %.
   - **Startup Loan EMI Calculator:** Loan principal, annual interest rate, tenure months &rarr; Monthly installment, total interest, total repayment.
   - **Monthly Enterprise Savings Tracker:** Income, expenses &rarr; Net monthly surplus, savings rate %, financial health advisory.
   - Powered by Java API endpoints (`/api/calculate/*`) with automatic client-side fallback.

8. **About & Evaluator FAQs (`#screen-about`):**
   - Academic documentation, problem statement, objectives, and technology specifications.
   - Interactive FAQ accordion addressing evaluator queries.

---

## 🔌 API Endpoint Documentation

| Method | Endpoint | Query / Body Parameters | Output |
|---|---|---|---|
| `GET` | `/api/data` | None | Full JSON dataset (resources, ideas, tools, schemes, stories, faqs) |
| `GET` / `POST` | `/api/calculate/profit` | `sellingPrice`, `costPrice`, `quantity` | `{"success": true, "revenue": ..., "cost": ..., "profit": ..., "margin": ..., "isProfit": ...}` |
| `GET` / `POST` | `/api/calculate/emi` | `loanAmount`, `annualRate`, `tenureMonths` | `{"success": true, "monthlyEmi": ..., "totalInterest": ..., "totalPayment": ...}` |
| `GET` / `POST` | `/api/calculate/savings` | `monthlyIncome`, `monthlyExpenses` | `{"success": true, "monthlySavings": ..., "savingsRate": ..., "isPositive": ...}` |

---

## 🎓 Academic Notice
This application is created solely for educational purposes as part of a college Community Engagement Project (CEP). All government scheme data and demonstration stories are curated for academic evaluation.
