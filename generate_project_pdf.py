import os
import sys
from reportlab.lib.pagesizes import A4
from reportlab.lib.colors import HexColor, white, black
from reportlab.lib.styles import getSampleStyleSheet, ParagraphStyle
from reportlab.platypus import (
    SimpleDocTemplate, Paragraph, Spacer, Table, TableStyle, PageBreak, KeepTogether, HRFlowable
)
from reportlab.pdfgen import canvas

# Colors
C_PRIMARY = HexColor("#1B5E20")      # Forest Green
C_PRIMARY_LIGHT = HexColor("#2E7D32")
C_PRIMARY_SOFT = HexColor("#E8F5E9")
C_ACCENT = HexColor("#E65100")       # Warm Amber/Orange
C_ACCENT_SOFT = HexColor("#FFF8E1")
C_DARK = HexColor("#19211E")
C_MUTED = HexColor("#596561")
C_LIGHT_BG = HexColor("#F8FAF8")
C_BORDER = HexColor("#D0DDD4")
C_BLUE_SOFT = HexColor("#E3F2FD")

class NumberedCanvas(canvas.Canvas):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self._saved_page_states = []

    def showPage(self):
        self._saved_page_states.append(dict(self.__dict__))
        self._startPage()

    def save(self):
        num_pages = len(self._saved_page_states)
        for state in self._saved_page_states:
            self.__dict__.update(state)
            self.draw_page_decorations(num_pages)
            super().showPage()
        super().save()

    def draw_page_decorations(self, page_count):
        if self._pageNumber == 1:
            return  # Skip cover page
        self.saveState()
        self.setFont("Helvetica-Bold", 8)
        self.setFillColor(C_PRIMARY)
        self.drawString(54, 804, "RuralRise / GramTech")
        self.setFont("Helvetica", 8)
        self.setFillColor(C_MUTED)
        self.drawString(155, 804, "| Technology Support for Rural Startups — Academic CEP Report")

        self.setStrokeColor(C_BORDER)
        self.setLineWidth(0.6)
        self.line(54, 796, 541, 796)

        # Footer
        self.line(54, 45, 541, 45)
        self.setFont("Helvetica", 8)
        self.setFillColor(C_MUTED)
        self.drawString(54, 32, "College Community Engagement Project (CEP) • Java Web Edition")
        page_text = f"Page {self._pageNumber} of {page_count}"
        self.drawRightString(541, 32, page_text)
        self.restoreState()


def create_project_report(pdf_filename):
    doc = SimpleDocTemplate(
        pdf_filename,
        pagesize=A4,
        leftMargin=54,
        rightMargin=54,
        topMargin=54,
        bottomMargin=54
    )

    styles = getSampleStyleSheet()

    # Custom typography styles
    title_style = ParagraphStyle(
        'DocTitle',
        parent=styles['Normal'],
        fontName='Helvetica-Bold',
        fontSize=24,
        leading=28,
        textColor=C_PRIMARY,
        alignment=0,
        spaceAfter=8
    )

    subtitle_style = ParagraphStyle(
        'DocSubTitle',
        parent=styles['Normal'],
        fontName='Helvetica-Bold',
        fontSize=13,
        leading=16,
        textColor=C_ACCENT,
        alignment=0,
        spaceAfter=14
    )

    h1_style = ParagraphStyle(
        'Heading1_Custom',
        parent=styles['Heading1'],
        fontName='Helvetica-Bold',
        fontSize=15,
        leading=18,
        textColor=C_PRIMARY,
        spaceBefore=16,
        spaceAfter=8,
        keepWithNext=True
    )

    h2_style = ParagraphStyle(
        'Heading2_Custom',
        parent=styles['Heading2'],
        fontName='Helvetica-Bold',
        fontSize=12,
        leading=15,
        textColor=C_PRIMARY_LIGHT,
        spaceBefore=12,
        spaceAfter=6,
        keepWithNext=True
    )

    body_style = ParagraphStyle(
        'Body_Custom',
        parent=styles['BodyText'],
        fontName='Helvetica',
        fontSize=9.5,
        leading=13.5,
        textColor=C_DARK,
        spaceAfter=6
    )

    body_bold = ParagraphStyle(
        'Body_Bold',
        parent=body_style,
        fontName='Helvetica-Bold'
    )

    bullet_style = ParagraphStyle(
        'Bullet_Custom',
        parent=body_style,
        leftIndent=14,
        firstLineIndent=-10,
        spaceAfter=4
    )

    callout_style = ParagraphStyle(
        'Callout_Text',
        parent=body_style,
        fontSize=9,
        leading=12.5,
        textColor=HexColor("#2E3A33")
    )

    table_header = ParagraphStyle(
        'TableHeader',
        parent=styles['Normal'],
        fontName='Helvetica-Bold',
        fontSize=8.5,
        leading=11,
        textColor=white
    )

    table_cell = ParagraphStyle(
        'TableCell',
        parent=styles['Normal'],
        fontName='Helvetica',
        fontSize=8.2,
        leading=10.5,
        textColor=C_DARK
    )

    table_cell_bold = ParagraphStyle(
        'TableCellBold',
        parent=table_cell,
        fontName='Helvetica-Bold',
        textColor=C_PRIMARY
    )

    story = []

    # ===============================================================
    # COVER / TITLE BLOCK
    # ===============================================================
    story.append(Spacer(1, 25))
    badge_table = Table(
        [[Paragraph("<font color='#E65100'><b>COLLEGE COMMUNITY ENGAGEMENT PROJECT (CEP) REPORT</b></font>", callout_style)]],
        colWidths=[487],
        style=[
            ('BACKGROUND', (0,0), (-1,-1), C_ACCENT_SOFT),
            ('BOX', (0,0), (-1,-1), 1, HexColor("#FFE082")),
            ('PADDING', (0,0), (-1,-1), 6),
            ('ALIGN', (0,0), (-1,-1), 'CENTER')
        ]
    )
    story.append(badge_table)
    story.append(Spacer(1, 16))

    story.append(Paragraph("RuralRise / GramTech", title_style))
    story.append(Paragraph("Technology Support for Rural Startups — Project Dossier", subtitle_style))
    story.append(HRFlowable(width="100%", thickness=2, color=C_PRIMARY, spaceBefore=4, spaceAfter=14))

    meta_data = [
        [Paragraph("<b>Topic:</b>", table_cell_bold), Paragraph("Technology Support for Rural Startups", table_cell),
         Paragraph("<b>Date:</b>", table_cell_bold), Paragraph("Academic Year 2025-2026", table_cell)],
        [Paragraph("<b>Application:</b>", table_cell_bold), Paragraph("RuralRise / GramTech Web Application", table_cell),
         Paragraph("<b>Tech Stack:</b>", table_cell_bold), Paragraph("Standard Java 21 + HTML5/CSS3/JS", table_cell)],
        [Paragraph("<b>Architecture:</b>", table_cell_bold), Paragraph("com.sun.net.httpserver.HttpServer (Zero External JARs)", table_cell),
         Paragraph("<b>Execution URL:</b>", table_cell_bold), Paragraph("http://localhost:8080", table_cell)]
    ]
    t_meta = Table(meta_data, colWidths=[80, 180, 80, 147])
    t_meta.setStyle(TableStyle([
        ('BACKGROUND', (0,0), (-1,-1), C_LIGHT_BG),
        ('BOX', (0,0), (-1,-1), 1, C_BORDER),
        ('INNERGRID', (0,0), (-1,-1), 0.5, C_BORDER),
        ('PADDING', (0,0), (-1,-1), 6),
        ('VALIGN', (0,0), (-1,-1), 'MIDDLE'),
    ]))
    story.append(t_meta)
    story.append(Spacer(1, 16))

    # Executive Summary Callout Box
    summary_html = (
        "<b>Project Purpose & Synopsis:</b><br/>"
        "RuralRise / GramTech is an educational web prototype developed to empower village entrepreneurs, "
        "women-led Self-Help Groups (SHGs), traditional craftspeople, and smallholder farmers. "
        "The system removes middleman barriers by training founders in digital payments, WhatsApp commerce, "
        "practical costing guidance, and actionable enterprise blueprints. "
        "Designed for academic evaluation, the software runs locally on a built-in Java HTTP server with "
        "zero database setup and zero internet dependency."
    )
    t_summary = Table(
        [[Paragraph(summary_html, callout_style)]],
        colWidths=[487],
        style=[
            ('BACKGROUND', (0,0), (-1,-1), C_PRIMARY_SOFT),
            ('BOX', (0,0), (-1,-1), 1, C_PRIMARY_LIGHT),
            ('PADDING', (0,0), (-1,-1), 10),
        ]
    )
    story.append(t_summary)
    story.append(Spacer(1, 16))

    # ===============================================================
    # SECTION 1: PROBLEM STATEMENT & CEP OBJECTIVES
    # ===============================================================
    story.append(Paragraph("1. Problem Statement & CEP Objectives", h1_style))
    story.append(Paragraph(
        "Rural enterprises produce high-quality agro-products, handloom textiles, and handicrafts, "
        "yet experience high failure rates and marginal revenues. Our Community Engagement Project identified key structural deficits:",
        body_style
    ))
    story.append(Paragraph("&bull; <b>Middlemen Dependency:</b> Village producers lose 40% to 65% of market value to intermediaries because they lack direct digital buyer access.", bullet_style))
    story.append(Paragraph("&bull; <b>Fear of Digital Fintech:</b> Apprehension regarding UPI payments, online transactions, and lack of verified safety awareness.", bullet_style))
    story.append(Paragraph("&bull; <b>Absent Financial Discipline:</b> Failure to separate home grocery expenses from shop capital, causing working capital exhaustion.", bullet_style))

    story.append(Spacer(1, 6))
    story.append(Paragraph("<b>Core Objectives of the RuralRise Software:</b>", body_bold))
    story.append(Paragraph("1. Deliver 11 structured, non-technical learning modules on pricing, digital sales, and cybersecurity.", bullet_style))
    story.append(Paragraph("2. Provide 8 turnkey rural enterprise blueprints with specific capital, skill, and technology requirements.", bullet_style))
    story.append(Paragraph("3. Present a modern, accessible web portal with instant search, category filtering, and dual view modes.", bullet_style))
    story.append(Paragraph("4. Enable 100% offline demonstration reliability powered by a standard Java HTTP server.", bullet_style))

    story.append(Spacer(1, 10))

    # ===============================================================
    # SECTION 2: TECHNICAL ARCHITECTURE & JAVA IMPLEMENTATION
    # ===============================================================
    story.append(Paragraph("2. Technical Architecture & Java Implementation", h1_style))
    story.append(Paragraph(
        "To guarantee 100% offline demonstration reliability during college evaluations without requiring heavy "
        "installations (like Spring Boot or MySQL), the application uses standard Java 21 built-in libraries:",
        body_style
    ))

    arch_data = [
        [Paragraph("Component", table_header), Paragraph("Source File", table_header), Paragraph("Role & Technical Implementation", table_header)],
        [
            Paragraph("<b>HTTP Web Server</b>", table_cell),
            Paragraph("<code>GramTechServer.java</code>", table_cell),
            Paragraph("Utilizes standard <code>com.sun.net.httpserver.HttpServer</code>. Handles automatic port fallback (8080/8081), CORS headers, and routes static assets and the <code>/api/data</code> endpoint.", table_cell)
        ],
        [
            Paragraph("<b>Data Repository</b>", table_cell),
            Paragraph("<code>logic/GramTechData.java</code>", table_cell),
            Paragraph("Static in-memory data store containing all 11 guides, 8 business models, 5 digital tool pillars, and FAQs, outputting JSON via <code>/api/data</code>.", table_cell)
        ],
        [
            Paragraph("<b>Interactive Frontend</b>", table_cell),
            Paragraph("<code>web/index.html<br/>web/styles.css<br/>web/app.js</code>", table_cell),
            Paragraph("Responsive Material 3 user interface with instant keyword search, category filter pills, modal drawers, and Dual View switcher (Desktop Portal vs Phone Frame).", table_cell)
        ],
        [
            Paragraph("<b>1-Click Runner</b>", table_cell),
            Paragraph("<code>run_web_app.bat</code>", table_cell),
            Paragraph("Automated batch file that detects JDK, compiles source files via <code>javac</code>, starts the server, and launches the browser.", table_cell)
        ]
    ]
    t_arch = Table(arch_data, colWidths=[95, 125, 267])
    t_arch.setStyle(TableStyle([
        ('BACKGROUND', (0,0), (-1,0), C_PRIMARY),
        ('GRID', (0,0), (-1,-1), 0.5, C_BORDER),
        ('PADDING', (0,0), (-1,-1), 5),
        ('VALIGN', (0,0), (-1,-1), 'TOP'),
        ('ROWBACKGROUNDS', (0,1), (-1,-1), [white, C_LIGHT_BG])
    ]))
    story.append(t_arch)

    # Page Break for clean section division
    story.append(PageBreak())

    # ===============================================================
    # SECTION 3: DETAILED BREAKDOWN OF APPLICATION SCREENS
    # ===============================================================
    story.append(Paragraph("3. Detailed Walkthrough of Application Screens & Sections", h1_style))

    # Screen 1: Home
    story.append(Paragraph("Screen 1: 🏡 Home Screen & Dual View Switcher", h2_style))
    story.append(Paragraph(
        "<b>Purpose:</b> Serves as the landing hub providing high-level context, quick statistics, and direct action shortcuts.<br/>"
        "&bull; <b>Hero Section:</b> Clear mission banner and call-to-action buttons (<i>Explore Guides</i>, <i>Business Ideas</i>, <i>Digital Tools</i>).<br/>"
        "&bull; <b>Live Statistics Strip:</b> Displays 11+ Practical Guides, 8 Business Models, 5 Digital Tool Pillars, and 100% Java Backend.<br/>"
        "&bull; <b>Dual View Switcher:</b> Located in the top bar. Enables college evaluators to toggle between <b>Desktop Portal Mode</b> (multi-column dashboard for projector screens) and <b>Smartphone Mockup Frame Mode</b> (420px mobile mockup with speaker notch and bottom navigation).",
        body_style
    ))

    story.append(Spacer(1, 4))

    # Screen 2: Learning Resources
    story.append(Paragraph("Screen 2: 📚 Learning Resources (Startup Guidance)", h2_style))
    story.append(Paragraph(
        "Contains <b>11 practical guides</b> designed with simple language and actionable steps. "
        "Includes real-time keyword search and 4 category filter tabs (*All Topics*, *Business Basics*, *Digital Skills*, *Financial Awareness*):",
        body_style
    ))

    guides_data = [
        [Paragraph("Guide Title", table_header), Paragraph("Category", table_header), Paragraph("Key Takeaway & Practical Advice", table_header)],
        [Paragraph("How to Start a Small Business", table_cell), Paragraph("Business Basics", table_cell), Paragraph("Identifying village needs, choosing proprietorship vs SHG, and obtaining free Udyam MSME certification.", table_cell)],
        [Paragraph("Basic Business Planning", table_cell), Paragraph("Business Basics", table_cell), Paragraph("Writing a simple 1-page business plan covering capital, operating expenses, and monthly break-even targets.", table_cell)],
        [Paragraph("Understanding Customers", table_cell), Paragraph("Business Basics", table_cell), Paragraph("Interviewing 20 local buyers at weekly haats before purchasing inventory to validate actual product demand.", table_cell)],
        [Paragraph("Pricing Your Products", table_cell), Paragraph("Business Basics", table_cell), Paragraph("True Price = (Raw Materials + Packaging + Fuel + Fair Labor Wages + 25% Profit Margin). Never treat own labor as free.", table_cell)],
        [Paragraph("Managing Business Expenses", table_cell), Paragraph("Business Basics", table_cell), Paragraph("Separating household cash from shop funds to prevent working capital depletion.", table_cell)],
        [Paragraph("Digital Marketing Basics", table_cell), Paragraph("Digital Skills", table_cell), Paragraph("Taking crisp daylight product photos with smartphones and posting in town WhatsApp groups.", table_cell)],
        [Paragraph("Social Media & WhatsApp", table_cell), Paragraph("Digital Skills", table_cell), Paragraph("Using WhatsApp Business catalogs, automated greetings, and order management tags.", table_cell)],
        [Paragraph("Online Payments & UPI Safety", table_cell), Paragraph("Digital Skills", table_cell), Paragraph("UPI Golden Rule: Entering PIN is strictly for SENDING money, never for receiving. Using soundboxes for audio alerts.", table_cell)],
        [Paragraph("Google Business & Visibility", table_cell), Paragraph("Digital Skills", table_cell), Paragraph("Creating free Google Maps listings with phone numbers to attract highway travelers and wholesale buyers.", table_cell)],
        [Paragraph("Understanding Startup Costs", table_cell), Paragraph("Finance", table_cell), Paragraph("Differentiating one-time fixed capital (tools) from 3 months of rolling working capital (seeds/materials).", table_cell)],
        [Paragraph("Loan Awareness & Credit Health", table_cell), Paragraph("Finance", table_cell), Paragraph("Building verifiable digital transaction statements via UPI deposits to qualify for low-interest formal credit.", table_cell)]
    ]
    t_guides = Table(guides_data, colWidths=[130, 85, 272])
    t_guides.setStyle(TableStyle([
        ('BACKGROUND', (0,0), (-1,0), C_PRIMARY),
        ('GRID', (0,0), (-1,-1), 0.5, C_BORDER),
        ('PADDING', (0,0), (-1,-1), 4),
        ('VALIGN', (0,0), (-1,-1), 'TOP'),
        ('ROWBACKGROUNDS', (0,1), (-1,-1), [white, C_LIGHT_BG])
    ]))
    story.append(t_guides)

    story.append(Spacer(1, 8))

    # Screen 3: Business Ideas
    story.append(Paragraph("Screen 3: 💡 Rural Business Ideas (Blueprints)", h2_style))
    story.append(Paragraph(
        "Features <b>8 turnkey rural business models</b> showing required capital, skills, and tools:",
        body_style
    ))

    ideas_data = [
        [Paragraph("Business Model", table_header), Paragraph("Capital Tier", table_header), Paragraph("Technology Stack & Revenue Model", table_header)],
        [Paragraph("Organic Farming & Direct Sales", table_cell), Paragraph("Low-Medium", table_cell), Paragraph("WhatsApp buyer groups, UPI advance QR payments; delivers weekly vegetable baskets directly to city apartment complexes.", table_cell)],
        [Paragraph("Food Processing & Pickles", table_cell), Paragraph("Medium", table_cell), Paragraph("Heat sealers, FSSAI digital registration, Instagram Reels; converts perishable mangoes/amla into high-margin packaged jars.", table_cell)],
        [Paragraph("Handicrafts & Artisanal Decor", table_cell), Paragraph("Low", table_cell), Paragraph("Smartphone photography, ONDC e-commerce catalogs, India Post tracking; elevates bamboo/pottery into national gifting items.", table_cell)],
        [Paragraph("Smart Dairy Management", table_cell), Paragraph("Medium-High", table_cell), Paragraph("Digital fat/SNF milk testers, cattle health apps, SMS ledger; fair price realization paid directly into bank accounts.", table_cell)],
        [Paragraph("Rural Tourism & Farmstays", table_cell), Paragraph("Medium", table_cell), Paragraph("Google Maps listing, online advance booking; hosts urban families for authentic village cuisine and farm culture.", table_cell)],
        [Paragraph("Agri Equipment Rental", table_cell), Paragraph("High", table_cell), Paragraph("GPS tracking, mobile booking register; Custom Hiring Centre renting mini tractors and power sprayers to smallholders.", table_cell)],
        [Paragraph("Rural Last-Mile Delivery", table_cell), Paragraph("Low", table_cell), Paragraph("Delivery tracking apps, digital signatures; acts as trusted village cluster parcel pickup and dispatch hub.", table_cell)],
        [Paragraph("Digital Village Service Center", table_cell), Paragraph("Low-Medium", table_cell), Paragraph("Desktop PC, biometric fingerprint scanner, broadband; CSC providing Aadhaar, utility bills, and scholarship filings.", table_cell)]
    ]
    t_ideas = Table(ideas_data, colWidths=[130, 85, 272])
    t_ideas.setStyle(TableStyle([
        ('BACKGROUND', (0,0), (-1,0), C_PRIMARY_LIGHT),
        ('GRID', (0,0), (-1,-1), 0.5, C_BORDER),
        ('PADDING', (0,0), (-1,-1), 4),
        ('VALIGN', (0,0), (-1,-1), 'TOP'),
        ('ROWBACKGROUNDS', (0,1), (-1,-1), [white, C_LIGHT_BG])
    ]))
    story.append(t_ideas)

    story.append(PageBreak())

    # Screen 4: Digital Tools
    story.append(Paragraph("Screen 4: 🛠️ Essential Digital Tools Directory", h2_style))
    story.append(Paragraph(
        "Structured into <b>5 practical functional pillars</b> enabling rural startups to operate digitally without IT overhead:",
        body_style
    ))
    story.append(Paragraph("&bull; <b>1. Communication (💬):</b> WhatsApp Business, Voice/Video Calls, Email &rarr; Free in-app catalogs and automated welcome messages.", bullet_style))
    story.append(Paragraph("&bull; <b>2. Marketing (📢):</b> Instagram Reels, Facebook Community Groups, Canva Graphic Creator &rarr; Zero-cost viral video promotion.", bullet_style))
    story.append(Paragraph("&bull; <b>3. Payments (💳):</b> UPI QR Code Standees, BHIM / PhonePe / GPay, UPI Soundbox &rarr; Instant audio settlement alerts and zero bad debts.", bullet_style))
    story.append(Paragraph("&bull; <b>4. Productivity (📊):</b> Google Sheets, Digital Ledger (Khata App), Cloud Drive &rarr; Automated sales tracking and paperless debt books.", bullet_style))
    story.append(Paragraph("&bull; <b>5. Learning (🎓):</b> YouTube Video Tutorials, Kisan Suvidha App, Skill India Portal &rarr; Free crop diagnosis and machine maintenance tutorials.", bullet_style))

    story.append(Spacer(1, 10))

    # Screen 5: About & FAQs
    story.append(Paragraph("Screen 5: ℹ️ About & Evaluator FAQs", h2_style))
    story.append(Paragraph(
        "Documents academic objectives, Community Engagement Project problem statement, "
        "and interactive evaluator FAQ accordion addressing common viva questions.",
        body_style
    ))

    story.append(Spacer(1, 14))

    # ===============================================================
    # SECTION 4: REST API SPECIFICATION
    # ===============================================================
    story.append(Paragraph("4. Backend REST API Endpoint Specification", h1_style))
    story.append(Paragraph(
        "The native Java HTTP server exposes a clean JSON endpoint with full CORS headers:",
        body_style
    ))

    api_data = [
        [Paragraph("Endpoint", table_header), Paragraph("HTTP Method", table_header), Paragraph("Parameters / Body", table_header), Paragraph("Description & Output", table_header)],
        [
            Paragraph("<code>/api/data</code>", table_cell),
            Paragraph("GET", table_cell),
            Paragraph("None", table_cell),
            Paragraph("Full JSON catalog containing all 11 guides, 8 business models, 5 digital tool pillars, and FAQs.", table_cell)
        ],
        [
            Paragraph("<code>/</code>", table_cell),
            Paragraph("GET", table_cell),
            Paragraph("Path (HTML/CSS/JS)", table_cell),
            Paragraph("Serves static web application files (<code>index.html</code>, <code>styles.css</code>, <code>app.js</code>) with correct MIME types.", table_cell)
        ]
    ]
    t_api = Table(api_data, colWidths=[110, 70, 120, 187])
    t_api.setStyle(TableStyle([
        ('BACKGROUND', (0,0), (-1,0), C_PRIMARY),
        ('GRID', (0,0), (-1,-1), 0.5, C_BORDER),
        ('PADDING', (0,0), (-1,-1), 6),
        ('VALIGN', (0,0), (-1,-1), 'TOP'),
        ('ROWBACKGROUNDS', (0,1), (-1,-1), [white, C_LIGHT_BG])
    ]))
    story.append(t_api)

    story.append(Spacer(1, 14))

    # ===============================================================
    # SECTION 5: COLLEGE PRESENTATION & VIVA PREPARATION GUIDE
    # ===============================================================
    story.append(Paragraph("5. College Presentation & Viva Cheatsheet", h1_style))
    story.append(Paragraph(
        "Prepared answers for common questions asked by academic examiners and evaluation committees:",
        body_style
    ))

    viva_data = [
        [Paragraph("Frequently Asked Question", table_header), Paragraph("Recommended Technical & Academic Response", table_header)],
        [
            Paragraph("<b>What inspired this topic?</b>", table_cell_bold),
            Paragraph("Rural entrepreneurs frequently produce premium organic and handcrafted goods but suffer from low margins due to intermediaries. Our CEP software demonstrates how affordable smartphones, UPI, and online catalogs bridge rural enterprises directly to high-value markets.", table_cell)
        ],
        [
            Paragraph("<b>Why use standard Java instead of Spring Boot or Node.js?</b>", table_cell_bold),
            Paragraph("College demonstrations require zero installation friction. Using standard Java's built-in <code>com.sun.net.httpserver</code> eliminates heavy build tools, 500MB dependency downloads, and setup failures. It starts in under 1 second on any machine with JDK.", table_cell)
        ],
        [
            Paragraph("<b>Where is the database located?</b>", table_cell_bold),
            Paragraph("To satisfy academic offline evaluation constraints, all educational content is structured as an in-memory JSON data repository in <code>GramTechData.java</code>. This avoids database crash risks and makes the prototype 100% portable.", table_cell)
        ],
        [
            Paragraph("<b>What is the purpose of Dual View Mode?</b>", table_cell_bold),
            Paragraph("It allows evaluators to assess both desktop portal ergonomics (for wide laptop/projector presentations) and responsive mobile UX (simulating how a village artisan views the application on a smartphone).", table_cell)
        ]
    ]
    t_viva = Table(viva_data, colWidths=[150, 337])
    t_viva.setStyle(TableStyle([
        ('BACKGROUND', (0,0), (-1,0), C_PRIMARY_LIGHT),
        ('GRID', (0,0), (-1,-1), 0.5, C_BORDER),
        ('PADDING', (0,0), (-1,-1), 5),
        ('VALIGN', (0,0), (-1,-1), 'TOP'),
        ('ROWBACKGROUNDS', (0,1), (-1,-1), [white, C_LIGHT_BG])
    ]))
    story.append(t_viva)

    story.append(Spacer(1, 16))

    # Sign-off box
    sign_html = (
        "<b>Project Submission Confirmation:</b><br/>"
        "Project: Technology Support for Rural Startups (RuralRise / GramTech)<br/>"
        "Status: Fully Implemented, Compiled & Verified &bull; Active at <code>http://localhost:8080</code><br/>"
        "Ready for Academic Evaluation & Presentation."
    )
    t_sign = Table([[Paragraph(sign_html, callout_style)]], colWidths=[487],
                   style=[('BACKGROUND', (0,0), (-1,-1), C_PRIMARY_SOFT),
                          ('BOX', (0,0), (-1,-1), 1, C_PRIMARY),
                          ('PADDING', (0,0), (-1,-1), 8)])
    story.append(t_sign)

    # Build the document
    doc.build(story, canvasmaker=NumberedCanvas)
    print(f"[OK] PDF successfully generated: {pdf_filename} ({os.path.getsize(pdf_filename)} bytes)")

if __name__ == "__main__":
    out_pdf = os.path.abspath(os.path.join(os.path.dirname(__file__), "GramTech_Rural_Startup_Project_Report.pdf"))
    create_project_report(out_pdf)
