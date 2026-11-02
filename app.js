/**
 * RuralRise / GramTech — Web Application Core (ES6)
 * College CEP Project: "Technology Support for Rural Startups"
 * Works with Java Backend API (/api/data) & Offline Fallback Data
 */

// Application State
const AppState = {
    currentSection: "home",
    isPhoneMode: false,
    activeCategory: "all",
    searchQuery: "",
    data: null // will be loaded from /api/data or fallback
};

// ==========================================
// 1. DATA REPOSITORY (Offline Fallback Guarantee)
// ==========================================
const LocalFallbackData = {
    resources: [
        {
            id: "res-1",
            category: "business",
            title: "How to Start a Small Business",
            desc: "Key steps for identifying village market needs, registering a trade name, and choosing the right rural enterprise model.",
            tag: "Startup Basics",
            readTime: "4 min read",
            icon: "🚀",
            summary: "Systematic steps to transform a rural business idea into a legal, sustainable venture.",
            details: "<p>Starting a rural venture begins with solving a genuine local problem—such as lack of cold storage, expensive transport, or missing grocery items.</p><p><strong>Key Action Steps:</strong></p><ol><li>Identify local demand through interviews at weekly haats.</li><li>Choose an enterprise structure (Proprietorship or SHG Bachat Gat).</li><li>Register for a free <strong>Udyam MSME</strong> certificate online.</li><li>Open a separate commercial current account at your nearest bank.</li><li>Establish reliable raw material suppliers before taking customer orders.</li></ol>"
        },
        {
            id: "res-2",
            category: "business",
            title: "Basic Business Planning",
            desc: "Writing a straightforward 1-page business plan covering capital requirements, production timelines, and target buyers.",
            tag: "Planning",
            readTime: "5 min read",
            icon: "📋",
            summary: "A simple 1-page blueprint prevents expensive mistakes and clarifies your monthly profit targets.",
            details: "<p>A rural business plan needs only 5 components to be effective:</p><ul><li><strong>Product:</strong> What makes your item higher quality or fresher than town retail?</li><li><strong>Target Customer:</strong> Local villagers, weekly town haats, or city online buyers?</li><li><strong>Startup Capital:</strong> How much is needed for machines and initial raw materials?</li><li><strong>Working Capital:</strong> Rolling cash needed for 2-3 months of ingredients and fuel.</li><li><strong>Break-Even:</strong> How many units must be sold each month to cover costs?</li></ul>"
        },
        {
            id: "res-3",
            category: "business",
            title: "Understanding Customers",
            desc: "How to interview local and regional buyers to understand what products they genuinely want and what prices they pay.",
            tag: "Market Research",
            readTime: "3 min read",
            icon: "🤝",
            summary: "Never assume what buyers need; always observe and ask directly.",
            details: "<p>Visit weekly haats and talk with at least 20 local consumers before buying inventory. Ask them: What products do they currently travel to town to buy? Are they dissatisfied with existing quality? What price feels affordable? Would they buy in bulk if delivered directly to their doorstep?</p>"
        },
        {
            id: "res-4",
            category: "business",
            title: "Pricing Your Products",
            desc: "Learn how to include raw material costs, artisan labor wages, fuel, and packaging to ensure healthy profit margins.",
            tag: "Costing",
            readTime: "4 min read",
            icon: "🏷️",
            summary: "Price your goods by adding all true input costs plus fair labor plus healthy profit margin.",
            details: "<p>Many rural craftspeople underprice because they treat their own time as free. Use this formula:</p><p><code>True Selling Price = (Raw Materials + Packaging + Electricity/Fuel + Fair Daily Labor Wage + 20-30% Profit Margin)</code></p><p>Check competitor prices in nearby towns to ensure your product remains competitive while remaining sustainably profitable.</p>"
        },
        {
            id: "res-5",
            category: "business",
            title: "Managing Business Expenses",
            desc: "Differentiating between personal household money and shop money, tracking daily cash flows, and avoiding wastage.",
            tag: "Bookkeeping",
            readTime: "3 min read",
            icon: "📚",
            summary: "Strictly separate domestic household cash from commercial working capital.",
            details: "<p>Maintain two separate registers or digital ledger apps: one for business purchases/sales and one for personal home expenses. Never dip into business sales cash for household groceries without recording an owner draw. This discipline protects working capital for restocking inventory.</p>"
        },
        {
            id: "res-6",
            category: "digital",
            title: "Digital Marketing Basics",
            desc: "Using everyday smartphones, photo editing, and messaging apps to promote village handcrafted and farm goods.",
            tag: "Marketing",
            readTime: "5 min read",
            icon: "📢",
            summary: "Reach hundreds of city buyers using free smartphone cameras and WhatsApp groups.",
            details: "<p>Take clean, high-resolution daylight photographs of your products against simple neutral backgrounds. Write clear product descriptions stating weight, materials, ingredients, and prices. Share posts in regional WhatsApp community groups, local Facebook pages, and college networks.</p>"
        },
        {
            id: "res-7",
            category: "digital",
            title: "Social Media & WhatsApp Business",
            desc: "Creating WhatsApp Business catalogs and sharing authentic behind-the-scenes production videos on Instagram reels.",
            tag: "Social Commerce",
            readTime: "4 min read",
            icon: "💬",
            summary: "Turn everyday messaging into a 24/7 digital storefront with instant ordering.",
            details: "<p>WhatsApp Business allows you to create an in-app product catalog with pictures, descriptions, and prices. Configure automated welcome messages, quick replies for frequent queries (e.g., shipping rates, payment QR), and organize buyer chats with tags like 'Order Received' and 'Shipped'.</p>"
        },
        {
            id: "res-8",
            category: "digital",
            title: "Online Payments & UPI Safety",
            desc: "Adopting QR code standees and soundboxes for instant bank settlements while avoiding OTP and phishing scams.",
            tag: "Fintech & Safety",
            readTime: "4 min read",
            icon: "💳",
            summary: "Accept payments effortlessly while keeping your bank balance completely secure.",
            details: "<p>Print a laminated UPI QR code connected directly to your business account. Golden rule of UPI: <strong>Entering your UPI PIN is ONLY done when YOU are SENDING money, NEVER when RECEIVING money.</strong> Never click unknown SMS links and never share one-time passwords (OTP) with callers.</p>"
        },
        {
            id: "res-9",
            category: "digital",
            title: "Google Business & Local Visibility",
            desc: "Setting up a Google Business profile with your address, contact numbers, and opening hours so regional travelers find you.",
            tag: "Local SEO",
            readTime: "3 min read",
            icon: "📍",
            summary: "Put your shop or workshop on Google Maps so travelers and town customers discover you.",
            details: "<p>Create a free Google Business Profile with your workshop location, operating hours, phone number, and product photos. Encourage satisfied travelers and visitors to leave 5-star Google reviews. This drives direct highway traffic and wholesale buyer visits.</p>"
        },
        {
            id: "res-10",
            category: "finance",
            title: "Understanding Startup Costs",
            desc: "Distinguishing between one-time fixed capital (tools, equipment) and recurring working capital (ingredients, wages).",
            tag: "Budgeting",
            readTime: "4 min read",
            icon: "💰",
            summary: "Calculate fixed capital vs working capital before launching commercial operations.",
            details: "<p>Fixed capital includes machines, sheds, and equipment that last for years. Working capital is the rolling cash needed for 2-3 months of raw materials, packaging, electricity, and transport before customer sales revenue starts flowing back in.</p>"
        },
        {
            id: "res-11",
            category: "finance",
            title: "Loan Awareness & Credit Health",
            desc: "How maintaining a digital bank transaction statement helps small entrepreneurs secure bank loans with lower interest.",
            tag: "Credit Health",
            readTime: "5 min read",
            icon: "📈",
            summary: "Build a strong banking track record to qualify for low-interest formal credit.",
            details: "<p>Banks approve loans based on proof of cash flow. Depositing cash sales regularly into your account and accepting UPI payments builds a verifiable digital bank statement. Repay small credit lines on time to maintain a solid credit score.</p>"
        }
    ],

    businessIdeas: [
        {
            id: "idea-1",
            title: "Organic Farming & Direct Sales",
            desc: "Chemical-free vegetable and fruit cultivation with direct-to-consumer digital subscription models in nearby towns.",
            skills: "Crop planning, organic soil preparation, grading, packaging.",
            technology: "WhatsApp buyer groups, UPI payments, weather forecast mobile apps.",
            icon: "🌱",
            investment: "Low to Medium",
            details: "Bypasses mandi middlemen by delivering weekly vegetable baskets directly to apartment societies in neighboring cities. Advance payments received via UPI QR codes provide steady cash flow."
        },
        {
            id: "idea-2",
            title: "Food Processing & Pickles",
            desc: "Value-addition to raw farm produce by processing mangoes, amla, chilies, and grains into standardized snacks and pickles.",
            skills: "Traditional recipe formulation, hygienic packaging, quality control.",
            technology: "Tamper-evident heat sealers, FSSAI digital registration, Instagram Reels.",
            icon: "🍯",
            investment: "Medium",
            details: "Raw harvest prices fluctuate heavily. Transforming fruit into packaged pickles, jams, or roasted spice mixes triples the shelf life and yields 40% higher net margins per kilogram."
        },
        {
            id: "idea-3",
            title: "Handicrafts & Artisanal Decor",
            desc: "Selling traditional village cane weaving, pottery, and handloom fabrics through online digital marketplaces and social commerce.",
            skills: "Artisan craftsmanship, product design consistency, protective boxing.",
            technology: "Digital smartphone photography, ONDC e-commerce catalogs, India Post tracking.",
            icon: "🧺",
            investment: "Low",
            details: "Urban buyers value authentic handmade goods. Using clean daylight photography and sharing artisan story videos elevates products from village weekly markets to high-value gifting items."
        },
        {
            id: "idea-4",
            title: "Smart Dairy Management",
            desc: "Micro-dairy setup utilizing digital milk analyzers, automated milking stations, and cold-chain supply coordination.",
            skills: "Animal husbandry, fodder nutrition, hygiene protocols.",
            technology: "Digital fat/SNF testers, cattle health tracking apps, automated SMS dairy ledger.",
            icon: "🥛",
            investment: "Medium to High",
            details: "Transparent digital milk testing ensures farmers receive fair rates based on butterfat content. Milk collection points credit funds directly to bank accounts every 10 days."
        },
        {
            id: "idea-5",
            title: "Rural Tourism & Farmstays",
            desc: "Hosting urban families and educational tours to experience village culture, traditional cuisine, and farm harvests.",
            skills: "Hospitality, tour curation, local folklore storytelling.",
            technology: "Google Maps listings, Airbnb/rural portals, digital advance booking.",
            icon: "🏡",
            investment: "Medium",
            details: "City residents eagerly seek peaceful weekend getaways. A tidy farmstay offering bullock cart rides and home-cooked organic meals generates substantial non-farm income."
        },
        {
            id: "idea-6",
            title: "Agricultural Equipment Rental",
            desc: "Custom Hiring Centre (CHC) offering small farmers shared access to mini tractors, solar pumps, and power weeders.",
            skills: "Machinery maintenance, scheduling, field operations.",
            technology: "Mobile booking registers, digital time logs, GPS equipment tracking.",
            icon: "🚜",
            investment: "High",
            details: "Smallholder farmers cannot afford expensive machinery. Hiring equipment at hourly rates saves farmers money while providing the entrepreneur steady seasonal rental revenue."
        },
        {
            id: "idea-7",
            title: "Rural Courier & Last-Mile Delivery",
            desc: "Hub-and-spoke distribution network connecting village clusters with district parcel centers for e-commerce deliveries.",
            skills: "Route optimization, inventory verification, customer service.",
            technology: "Delivery tracking apps, digital signature capture, UPI soundbox.",
            icon: "🚚",
            investment: "Low",
            details: "Major e-commerce companies and medicine distributors struggle with rural addresses. A local village entrepreneur acts as a trusted parcel pickup and delivery hub."
        },
        {
            id: "idea-8",
            title: "Digital Village Service Center",
            desc: "Single-window rural center providing Aadhaar services, certificate applications, printouts, and digital literacy assistance.",
            skills: "Computer literacy, document processing, patience in guiding elders.",
            technology: "Desktop PC, scanner/printer, biometric fingerprint scanner, high-speed broadband.",
            icon: "💻",
            investment: "Low to Medium",
            details: "Saves village residents from traveling 25 kilometers to the district headquarters for utility bill payments, certificate applications, and scholarship filings."
        }
    ],

    digitalTools: [
        {
            category: "Communication",
            icon: "💬",
            tools: ["WhatsApp Business", "Voice & Video Calls", "Email"],
            whatItDoes: "Enables instant real-time messaging, multimedia sharing, automated welcome replies, and catalog displays directly on mobile devices.",
            howItHelps: "Allows a village artisan or producer to chat with hundreds of prospective buyers simultaneously without expensive office infrastructure."
        },
        {
            category: "Marketing",
            icon: "📢",
            tools: ["Instagram Reels", "Facebook Groups", "Canva Graphic Creator"],
            whatItDoes: "Tools to design digital promotional posters, upload high-definition video clips, and connect with regional consumer groups.",
            howItHelps: "Bypasses costly newspaper ads, allowing small startups to build brand awareness virally across state borders for free."
        },
        {
            category: "Payments",
            icon: "💳",
            tools: ["UPI QR Codes", "BHIM / PhonePe / GPay", "UPI Soundbox"],
            whatItDoes: "Facilitates instant zero-fee account-to-account funds transfer with immediate audio and SMS receipt confirmations.",
            howItHelps: "Eliminates loose change hassles, guarantees instant receipt of advance payments, and generates bank statements to qualify for loans."
        },
        {
            category: "Productivity",
            icon: "📊",
            tools: ["Google Sheets / Excel", "Digital Ledger (Khata App)", "Cloud Drive"],
            whatItDoes: "Replaces paper registers with auto-calculating spreadsheets, digital debt tracking, and secure document cloud backups.",
            howItHelps: "Keeps track of customer credit without missing entries and protects vital tax/registration receipts against physical damage or loss."
        },
        {
            category: "Learning",
            icon: "🎓",
            tools: ["YouTube Tutorials", "Kisan Suvidha App", "Skill India Portal"],
            whatItDoes: "Free video-based learning hubs covering pest management, food processing protocols, machine maintenance, and pricing techniques.",
            howItHelps: "Empowers rural youth to self-train in advanced techniques from top agricultural universities without leaving their village."
        }
    ],

    faqs: [
        {
            q: "What is RuralRise / GramTech?",
            a: "RuralRise is a student-developed educational prototype created for a college CEP project on 'Technology Support for Rural Startups'. It demonstrates how digital tools, knowledge modules, and business blueprints empower rural entrepreneurs."
        },
        {
            q: "Who can use RuralRise?",
            a: "It is designed for rural entrepreneurs, students, SHG members, small farmers, and village innovators seeking practical business and digital skills guidance."
        },
        {
            q: "Does this website require an account or login?",
            a: "No. The application is completely open-access and operates with zero authentication or login barriers to allow effortless demonstration during college evaluations."
        },
        {
            q: "Is user information stored in a database?",
            a: "No. The project operates 100% locally with static data. No database, server tracking, or user information collection is performed."
        },
        {
            q: "How is this application powered by Java?",
            a: "The web application is served by a lightweight native Java HTTP server (com.sun.net.httpserver.HttpServer) that serves the startup knowledge repository and web assets."
        }
    ]
};

// ==========================================
// 2. INITIALIZATION & ROUTING
// ==========================================
document.addEventListener("DOMContentLoaded", () => {
    initApp();
});

async function initApp() {
    setupViewModeToggle();
    setupMobileDrawer();
    setupCategoryFilter();
    setupSearch();

    // Fetch live data from Java backend /api/data, fallback to LocalFallbackData
    await loadApplicationData();

    // Initial renders
    renderResources();
    renderIdeas();
    renderTools();
    renderFaqs();
}

async function loadApplicationData() {
    try {
        const response = await fetch("/api/data");
        if (response.ok) {
            const data = await response.json();
            AppState.data = data;
            const statusPill = document.getElementById("server-status-pill");
            if (statusPill) {
                statusPill.textContent = "● Java Server Connected (Port " + (window.location.port || "8080") + ")";
                statusPill.style.color = "#81C784";
            }
            return;
        }
    } catch (err) {
        console.warn("Notice: Live /api/data endpoint unavailable, using bundled data repository.", err);
    }
    // Fallback
    AppState.data = LocalFallbackData;
    const statusPill = document.getElementById("server-status-pill");
    if (statusPill) {
        statusPill.textContent = "● Standalone Frontend Mode";
    }
}

// Router Navigation
function navigateTo(sectionId) {
    AppState.currentSection = sectionId;

    // Toggle active page section
    document.querySelectorAll(".page-section").forEach(sec => {
        sec.classList.remove("active");
    });
    const targetSection = document.getElementById("screen-" + sectionId);
    if (targetSection) {
        targetSection.classList.add("active");
    }

    // Update Desktop Nav Links
    document.querySelectorAll(".nav-item").forEach(item => {
        item.classList.remove("active");
        if (item.getAttribute("data-target") === sectionId) {
            item.classList.add("active");
        }
    });

    // Update Phone Bottom Nav
    document.querySelectorAll(".p-nav-btn").forEach(btn => {
        btn.classList.remove("active");
        if (btn.getAttribute("data-target") === sectionId) {
            btn.classList.add("active");
        }
    });

    // Scroll smoothly to top
    window.scrollTo({ top: 0, behavior: "smooth" });
}

// ==========================================
// 3. VIEW MODE SWITCHER (Desktop vs Phone Mockup)
// ==========================================
function setupViewModeToggle() {
    const toggleBtn = document.getElementById("view-mode-toggle");
    const modeIcon = document.getElementById("view-mode-icon");
    const modeText = document.getElementById("view-mode-text");

    if (!toggleBtn) return;

    toggleBtn.addEventListener("click", () => {
        AppState.isPhoneMode = !AppState.isPhoneMode;
        if (AppState.isPhoneMode) {
            document.body.classList.remove("desktop-view");
            document.body.classList.add("phone-view");
            modeIcon.textContent = "🖥️";
            modeText.textContent = "Desktop View";
        } else {
            document.body.classList.remove("phone-view");
            document.body.classList.add("desktop-view");
            modeIcon.textContent = "📱";
            modeText.textContent = "Phone Frame";
        }
    });
}

// Mobile Drawer
function setupMobileDrawer() {
    const hamburger = document.getElementById("mobile-menu-toggle");
    const drawer = document.getElementById("mobile-drawer");
    const closeBtn = document.getElementById("drawer-close-btn");

    if (hamburger && drawer) {
        hamburger.addEventListener("click", () => drawer.classList.add("open"));
    }
    if (closeBtn && drawer) {
        closeBtn.addEventListener("click", () => drawer.classList.remove("open"));
    }
}

function closeDrawer() {
    const drawer = document.getElementById("mobile-drawer");
    if (drawer) drawer.classList.remove("open");
}

// ==========================================
// 4. SEARCH & CATEGORY FILTERS
// ==========================================
function setupCategoryFilter() {
    const pills = document.querySelectorAll(".cat-pill");
    pills.forEach(pill => {
        pill.addEventListener("click", (e) => {
            pills.forEach(p => p.classList.remove("active"));
            e.currentTarget.classList.add("active");
            AppState.activeCategory = e.currentTarget.getAttribute("data-cat");
            renderResources();
        });
    });
}

function setupSearch() {
    const searchInput = document.getElementById("resource-search-input");
    if (searchInput) {
        searchInput.addEventListener("input", (e) => {
            AppState.searchQuery = e.target.value.trim().toLowerCase();
            renderResources();
        });
    }
}

// ==========================================
// 5. RENDERERS
// ==========================================

function renderResources() {
    const container = document.getElementById("resources-cards-container");
    if (!container) return;

    const data = AppState.data || LocalFallbackData;
    const items = data.resources || LocalFallbackData.resources;

    const filtered = items.filter(item => {
        const matchesCategory = (AppState.activeCategory === "all" || item.category === AppState.activeCategory);
        const matchesQuery = !AppState.searchQuery ||
            item.title.toLowerCase().includes(AppState.searchQuery) ||
            item.desc.toLowerCase().includes(AppState.searchQuery) ||
            (item.tag && item.tag.toLowerCase().includes(AppState.searchQuery));
        return matchesCategory && matchesQuery;
    });

    if (filtered.length === 0) {
        container.innerHTML = `
            <div style="grid-column: 1 / -1; text-align: center; padding: 40px; background: #fff; border-radius: 14px; border: 1px dashed #ccc;">
                <p style="font-size: 1.1rem; color: #555;">No startup guides found matching "${AppState.searchQuery}".</p>
                <button class="btn-primary" style="margin-top: 12px;" onclick="resetResourceFilter()">View All Guides</button>
            </div>
        `;
        return;
    }

    container.innerHTML = filtered.map(item => `
        <div class="resource-card">
            <div class="resource-top">
                <span class="res-tag">${item.tag || "Guide"}</span>
                <span class="res-time">⏱️ ${item.readTime || "4 min"}</span>
            </div>
            <h3>${item.icon || "📄"} ${item.title}</h3>
            <p>${item.desc}</p>
            <button class="btn-card-action" onclick="openResourceModal('${item.id}')">
                Read Full Guide &rarr;
            </button>
        </div>
    `).join("");
}

function resetResourceFilter() {
    AppState.searchQuery = "";
    AppState.activeCategory = "all";
    const searchInput = document.getElementById("resource-search-input");
    if (searchInput) searchInput.value = "";
    document.querySelectorAll(".cat-pill").forEach(p => {
        p.classList.toggle("active", p.getAttribute("data-cat") === "all");
    });
    renderResources();
}

function renderIdeas() {
    const container = document.getElementById("ideas-cards-container");
    if (!container) return;

    const data = AppState.data || LocalFallbackData;
    const ideas = data.businessIdeas || LocalFallbackData.businessIdeas;

    container.innerHTML = ideas.map(idea => `
        <div class="idea-card">
            <div class="idea-header">
                <span class="idea-icon">${idea.icon || "💡"}</span>
                <div>
                    <h3>${idea.title}</h3>
                </div>
            </div>
            <div class="idea-tag-row">
                <span class="badge-invest">Capital: ${idea.investment || "Low"}</span>
            </div>
            <p class="idea-desc">${idea.desc}</p>
            <div class="idea-specs">
                <div>
                    <strong>Required Skills:</strong>
                    <span>${idea.skills}</span>
                </div>
                <div>
                    <strong>Recommended Technology:</strong>
                    <span>${idea.technology}</span>
                </div>
            </div>
            <button class="btn-card-action" onclick="openIdeaModal('${idea.id}')">
                View Operational Blueprint &rarr;
            </button>
        </div>
    `).join("");
}

function renderTools() {
    const container = document.getElementById("tools-cards-container");
    if (!container) return;

    const data = AppState.data || LocalFallbackData;
    const tools = data.digitalTools || LocalFallbackData.digitalTools;

    container.innerHTML = tools.map(pillar => `
        <div class="tool-pillar-card">
            <div class="pillar-lead">
                <span class="pillar-icon">${pillar.icon || "🛠️"}</span>
                <div>
                    <h3>${pillar.category}</h3>
                    <div class="tool-chips">
                        ${(pillar.tools || []).map(t => `<span class="tool-chip">${t}</span>`).join("")}
                    </div>
                </div>
            </div>
            <div class="pillar-detail">
                <h4>What it does</h4>
                <p>${pillar.whatItDoes}</p>
            </div>
            <div class="pillar-impact">
                <h4>Why it helps rural startups</h4>
                <p>${pillar.howItHelps}</p>
            </div>
        </div>
    `).join("");
}

function renderFaqs() {
    const container = document.getElementById("faq-accordion-container");
    if (!container) return;

    const data = AppState.data || LocalFallbackData;
    const faqs = data.faqs || LocalFallbackData.faqs;

    container.innerHTML = faqs.map((faq, index) => `
        <div class="faq-item ${index === 0 ? 'active' : ''}">
            <button class="faq-question" onclick="toggleFaq(this)">
                <span>${faq.q}</span>
                <span class="faq-arrow">▼</span>
            </button>
            <div class="faq-answer">
                <p>${faq.a}</p>
            </div>
        </div>
    `).join("");
}

function toggleFaq(btn) {
    const item = btn.closest(".faq-item");
    if (item) {
        item.classList.toggle("active");
    }
}

// ==========================================
// 6. MODAL SYSTEM
// ==========================================
function openModal(title, category, icon, htmlContent) {
    const modal = document.getElementById("detail-modal");
    if (!modal) return;

    document.getElementById("modal-title").textContent = title;
    document.getElementById("modal-category").textContent = category;
    document.getElementById("modal-icon").textContent = icon;
    document.getElementById("modal-content").innerHTML = htmlContent;

    modal.classList.add("open");
}

function closeModal() {
    const modal = document.getElementById("detail-modal");
    if (modal) modal.classList.remove("open");
}

function openResourceModal(resId) {
    const data = AppState.data || LocalFallbackData;
    const item = (data.resources || []).find(r => r.id === resId);
    if (!item) return;

    const content = `
        <div style="margin-bottom: 16px;">
            <p class="lead-text">${item.summary || item.desc}</p>
        </div>
        <div>
            ${item.details || `<p>${item.desc}</p>`}
        </div>
    `;

    openModal(item.title, item.tag || "Startup Guide", item.icon || "📄", content);
}

function openIdeaModal(ideaId) {
    const data = AppState.data || LocalFallbackData;
    const idea = (data.businessIdeas || []).find(i => i.id === ideaId);
    if (!idea) return;

    const content = `
        <div style="margin-bottom: 18px;">
            <span class="badge-invest" style="font-size: 0.85rem;">Estimated Capital: ${idea.investment}</span>
            <p style="margin-top: 12px; font-size: 1rem; color: #19211E;">${idea.desc}</p>
        </div>
        <div class="tech-spec-box" style="margin-bottom: 18px;">
            <p><strong>Operational Model & Revenue Strategy:</strong></p>
            <p style="margin-top: 6px;">${idea.details}</p>
        </div>
        <div class="idea-specs">
            <div><strong>Key Practical Skills:</strong> <span>${idea.skills}</span></div>
            <div><strong>Essential Digital Tools:</strong> <span>${idea.technology}</span></div>
        </div>
    `;

    openModal(idea.title, "Business Blueprint", idea.icon || "💡", content);
}
