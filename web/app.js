/**
 * GRAMTECH — JAVASCRIPT APPLICATION CORE
 * College CEP Project: "Technology Support for Rural Startups"
 * 100% Client-Side Local Data & Interactive Navigation
 */

// ==========================================
// 1. STATIC SAMPLE DATA (Zero Backend / Offline)
// ==========================================
const SampleData = {
    lessons: [
        {
            id: "digital-marketing",
            title: "Digital Marketing",
            subtitle: "Learn how social media can help promote your business.",
            icon: "📢",
            summary: "Reach customers across villages and towns without high advertising budgets.",
            whatIsIt: "Digital marketing means using the internet, smartphones, and online platforms to present your products and services directly to potential buyers.",
            whyUseful: [
                "Reach customers beyond your immediate local village market.",
                "Showcase product photos, videos, and customer reviews directly.",
                "Build trust and a recognizable brand name for your craft or farm.",
                "Receive instant customer inquiries directly on your phone.",
                "Increase sales with zero or very low advertising expenses."
            ],
            practicalExample: "A local handmade-products business can post product photos on WhatsApp and Instagram to reach customers outside the village.",
            keyTips: [
                "Post clear photos taken during daytime in natural lighting.",
                "Always mention product size, material, and price clearly.",
                "Respond quickly and politely to buyer inquiries.",
                "Ask satisfied customers to share your catalog with their friends."
            ]
        },
        {
            id: "digital-payments",
            title: "Digital Payments",
            subtitle: "Learn about UPI, QR codes and safe digital payments.",
            icon: "💳",
            summary: "Accept payments seamlessly and keep a crystal clear digital account ledger.",
            whatIsIt: "Digital payments allow you to receive money directly into your bank account using UPI apps (PhonePe, Google Pay, Paytm, BHIM) and QR codes without needing physical cash or loose change.",
            whyUseful: [
                "Eliminates the daily headache of finding loose cash and coins.",
                "Payments settle directly and instantly into your savings account.",
                "Creates an automatic digital bank statement that helps qualify for bank loans.",
                "Instant audio confirmation through UPI soundboxes avoids customer payment disputes.",
                "Allows distant customers to pay advance token amounts easily."
            ],
            practicalExample: "A village kirana store or tailoring shop prints a laminated UPI QR code standee. When customers scan and pay ₹150, the store owner gets instant SMS and audio notification.",
            keyTips: [
                "Never share your UPI PIN or OTP with anyone claiming to send you money.",
                "Remember: Entering your UPI PIN always deducts money from your account, never deposits it.",
                "Verify the sender name and amount on your banking app before handing over goods.",
                "Download your monthly UPI transaction statement for business accounting."
            ]
        },
        {
            id: "social-media",
            title: "Social Media",
            subtitle: "Learn how WhatsApp, Facebook and Instagram can help your business.",
            icon: "💬",
            summary: "Turn everyday chatting apps into powerful customer relationship channels.",
            whatIsIt: "Social media business channels enable rural entrepreneurs to maintain customer relationships, post new batch updates, and showcase production stories to genuine buyers.",
            whyUseful: [
                "WhatsApp Business provides a free digital product catalog inside the app.",
                "Facebook community groups connect you with local and state-level buyer circles.",
                "Instagram Reels allow you to show behind-the-scenes making of authentic handmade items.",
                "Automated away messages and greeting messages keep your store active 24/7.",
                "Direct one-on-one conversation builds genuine trust with distant consumers."
            ],
            practicalExample: "A self-help group producing organic turmeric powder sets up a WhatsApp Business account with catalog items priced at ₹120 per 250g pack, enabling city buyers to order in 2 taps.",
            keyTips: [
                "Install WhatsApp Business instead of regular WhatsApp to unlock catalog features.",
                "Set business working hours and an automatic greeting response.",
                "Post short 15-second videos showing raw ingredients and clean preparation.",
                "Keep customer numbers organized using labels like 'New Order', 'Paid', 'Dispatched'."
            ]
        },
        {
            id: "online-selling",
            title: "Online Selling",
            subtitle: "Learn how to sell products online.",
            icon: "🏪",
            summary: "Discover e-commerce channels, ONDC, and rural shipping partnerships.",
            whatIsIt: "Online selling involves listing your goods on digital platforms, online marketplaces, government portals, or direct social commerce so customers anywhere in India can purchase them.",
            whyUseful: [
                "Breaks geographic barriers, allowing a remote village artisan to sell nationally.",
                "Cuts out exploitative middlemen who take large profit cuts.",
                "Receives prepaid orders or cash-on-delivery through trusted courier services.",
                "Enables participation in government-backed initiatives like ONDC and GeM.",
                "Allows selling high-margin seasonal specialties like festive sweets and harvest honey."
            ],
            practicalExample: "A cane weaver lists bamboo laundry baskets on an ONDC-enabled seller application and ships them using India Post Parcel service, earning ₹450 per unit compared to ₹180 from local traders.",
            keyTips: [
                "Start small with 3 to 5 of your highest-demand products.",
                "Partner with local postal offices or parcel services for affordable transport.",
                "Use sturdy, moisture-proof packaging with bubble wrap or recycled cardboard.",
                "Always add a handwritten thank-you note inside the box to build repeat customers."
            ]
        },
        {
            id: "cyber-safety",
            title: "Cyber Safety",
            subtitle: "Learn how to protect yourself from online scams.",
            icon: "🛡️",
            summary: "Crucial safety habits to protect your hard-earned business revenue from fraudsters.",
            whatIsIt: "Cyber safety encompasses essential security practices to protect your smartphone, bank accounts, UPI apps, and personal identity from cyber criminals and online fraudsters.",
            whyUseful: [
                "Protects your business savings and daily earnings from fraudulent withdrawals.",
                "Prevents identity theft and misuse of your Aadhaar or PAN details.",
                "Guarantees that your online customer records and contacts stay secure.",
                "Ensures peace of mind while using modern digital banking and e-wallets.",
                "Helps you guide fellow village entrepreneurs against emerging fraudulent schemes."
            ],
            practicalExample: "A scammer calls claiming to be an army officer who wants to buy 50 jars of honey and sends a QR code asking the seller to scan it to 'receive' ₹10,000. The seller recognizes the scam and refuses.",
            keyTips: [
                "Scanning a QR code or entering a PIN is ONLY for paying money, NEVER for receiving money.",
                "Never share 4-digit or 6-digit OTP codes received via SMS with any caller.",
                "Do not click on suspicious SMS links claiming 'Electricity disconnected' or 'Lottery won'.",
                "Lock your phone with a fingerprint or secure PIN code."
            ]
        },
        {
            id: "business-basics",
            title: "Business Basics",
            subtitle: "Learn simple concepts such as pricing, profit and expenses.",
            icon: "📊",
            summary: "Fundamental bookkeeping and pricing wisdom to make your venture sustainable.",
            whatIsIt: "Business basics cover the simple arithmetic and financial disciplines needed to calculate actual production costs, set fair selling prices, and track true cash profit.",
            whyUseful: [
                "Helps calculate true total cost (raw material + labor + packaging + travel).",
                "Ensures you do not underprice your valuable handcrafted labor.",
                "Maintains a clear distinction between personal household money and business money.",
                "Allows tracking monthly expenses to identify unnecessary leakages.",
                "Prepares your enterprise to present clear financial numbers when requesting bank credit."
            ],
            practicalExample: "If making a jar of pickle costs ₹70 in ingredients, ₹20 in glass jar and label, and ₹15 in labor/fuel (Total ₹105), selling at ₹180 leaves a solid ₹75 profit per jar.",
            keyTips: [
                "Always pay yourself a fixed wage for your hours worked—labor is a true cost.",
                "Keep separate physical boxes or separate bank accounts for home and shop money.",
                "Write down daily sales and daily costs in a small register or smartphone notes app.",
                "Set aside 20% of profits every month to reinvest in bulk raw materials at cheaper rates."
            ]
        }
    ],

    schemes: [
        {
            id: "pm-mudra",
            name: "PM MUDRA Yojana",
            shortName: "MUDRA",

            tagline: "Funding the unfunded micro and small enterprises.",
            category: "Business Loan",
            purpose: "Provides collateral-free institutional credit up to ₹10 Lakhs to non-corporate, non-farm micro and small enterprises for income-generating activities.",
            whoMayBenefit: "Artisans, shopkeepers, fruit and vegetable vendors, food processors, repair shops, rural transport operators, and small manufacturing units.",
            financialSupport: "Three tiers: Shishu (up to ₹50,000), Kishore (₹50,000 to ₹5 Lakhs), and Tarun (₹5 Lakhs to ₹10 Lakhs).",
            keyFeatures: [
                "No collateral or third-party guarantee required.",
                "No processing fee for Shishu and Kishore loan categories.",
                "MUDRA RuPay debit card provided for flexible working capital withdrawals.",
                "Repayment tenure up to 5 to 7 years with affordable interest rates."
            ],
            officialPortalName: "mudra.org.in / udyamimitra.in",
            officialUrl: "https://www.mudra.org.in",
            officialUrlAdvice: "Visit your nearest public sector, regional rural (RRB), or cooperative bank branch, or apply online via www.udyamimitra.in."
        },
        {
            id: "startup-india",
            name: "Startup India",
            shortName: "Startup India",
            tagline: "Building an inclusive national startup ecosystem.",
            category: "Incubation & Grants",
            purpose: "Fosters innovation, provides seed funding support, intellectual property facilitation, and simplifies regulatory compliance for newly incorporated startups.",
            whoMayBenefit: "Technology-enabled ventures, agri-tech startups, rural innovations, and product creators registered as LLP or Private Limited within 10 years.",
            financialSupport: "Startup India Seed Fund Scheme (SISFS) grants up to ₹20 Lakhs for proof-of-concept and up to ₹50 Lakhs for commercialization via incubators.",
            keyFeatures: [
                "Income tax exemption for 3 consecutive years under section 80-IAC.",
                "80% rebate on patent filing fees and 50% on trademark filing.",
                "Fast-track government procurement exemptions on prior turnover.",
                "Access to free legal, mentoring, and investor pitch sessions."
            ],
            officialPortalName: "startupindia.gov.in",
            officialUrl: "https://www.startupindia.gov.in",
            officialUrlAdvice: "Register your startup entity online on www.startupindia.gov.in and explore recognized incubators in your state."
        },
        {
            id: "standup-india",
            name: "Stand-Up India",
            shortName: "Stand-Up India",
            tagline: "Promoting entrepreneurship among SC, ST & Women.",
            category: "Targeted Credit",
            purpose: "Facilitates bank loans between ₹10 Lakhs and ₹1 Crore to at least one Scheduled Caste (SC) or Scheduled Tribe (ST) borrower and at least one woman borrower per bank branch.",
            whoMayBenefit: "Women entrepreneurs and SC/ST individuals establishing greenfield (first-time) enterprises in manufacturing, services, agri-allied, or trading sectors.",
            financialSupport: "Composite loan (term loan + working capital) covering up to 85% of total project cost between ₹10 Lakhs and ₹100 Lakhs.",
            keyFeatures: [
                "Specifically designated per commercial bank branch across India.",
                "Handholding support through Lead District Managers and SIDBI.",
                "Margin money requirement reduced to 15% with convergence of other subsidies.",
                "Repayable in 7 years with a moratorium period of up to 18 months."
            ],
            officialPortalName: "standupmitra.in",
            officialUrl: "https://www.standupmitra.in",
            officialUrlAdvice: "Apply directly through the Stand-Up Mitra portal (www.standupmitra.in) or visit your local nationalized bank branch."
        },
        {
            id: "pmegp",
            name: "PMEGP (Prime Minister Employment Generation)",
            shortName: "PMEGP",
            tagline: "Credit-linked capital subsidy for new micro-units.",
            category: "Govt Subsidy",
            purpose: "Generates continuous employment opportunities in rural and urban areas by helping traditional artisans and unemployed youth set up micro-enterprises.",
            whoMayBenefit: "Individuals aged 18+ with at least 8th standard pass for projects above ₹10 Lakhs (manufacturing) or ₹5 Lakhs (service). Self-help groups and cooperative societies also qualify.",
            financialSupport: "Project cost up to ₹50 Lakhs (manufacturing) and ₹20 Lakhs (services). Government subsidy ranges from 15% to 35% of project cost (higher in rural areas).",
            keyFeatures: [
                "Substantial capital subsidy (up to 35% in rural areas for special categories).",
                "Administered at ground level by KVIC, KVIB, and District Industries Centres (DIC).",
                "Beneficiary contribution is only 5% to 10% of total project capital.",
                "Mandatory 10-day Entrepreneurship Development Programme (EDP) training."
            ],
            officialPortalName: "kviconline.gov.in/pmegpeportal",
            officialUrl: "https://www.kviconline.gov.in/pmegpeportal/",
            officialUrlAdvice: "Submit an online application via the KVIC e-portal (www.kviconline.gov.in) and coordinate with your District Industries Centre (DIC)."
        },
        {
            id: "pm-vishwakarma",
            name: "PM Vishwakarma Scheme",
            shortName: "Vishwakarma",
            tagline: "Empowering traditional artisans and craftspeople.",
            category: "Artisan Upliftment",
            purpose: "Provides holistic end-to-end support to traditional artisans and craftspeople working with their hands and tools across 18 traditional trades.",
            whoMayBenefit: "Carpenters, boat makers, blacksmiths, armorers, locksmiths, potters, sculptors, cobblers, masons, basket/mat/broom makers, doll & toy makers, barbers, garland makers, washermen, tailors, and fishing net makers.",
            financialSupport: "Collateral-free enterprise credit up to ₹1 Lakh (Tier 1 at 5% concessional interest) and additional ₹2 Lakhs (Tier 2). Toolkit incentive of ₹15,000.",
            keyFeatures: [
                "Official recognition as 'PM Vishwakarma' with certificate and ID card.",
                "5-7 days basic skill training with a daily stipend of ₹500.",
                "₹15,000 modern toolkit grant via e-voucher.",
                "Incentive for digital transactions (₹1 per transaction up to 100/month) and marketing support."
            ],
            officialPortalName: "pmvishwakarma.gov.in",
            officialUrl: "https://pmvishwakarma.gov.in",
            officialUrlAdvice: "Register free of charge at any Common Services Centre (CSC) in your Gram Panchayat or on www.pmvishwakarma.gov.in."
        },
        {
            id: "skill-india",
            name: "Skill India (PMKVY)",
            shortName: "Skill India",
            tagline: "Skill development and industry-ready training.",
            category: "Skill Training",
            purpose: "Empowers youth and rural entrepreneurs with industry-relevant skill training, digital literacy, and recognized certifications to improve livelihood avenues.",
            whoMayBenefit: "School/college dropouts, rural youth seeking self-employment, and existing workers wishing to assess and certify existing informal skills (RPL).",
            financialSupport: "100% government-sponsored free training, assessment fees covered, and monetary reward on successful certification.",
            keyFeatures: [
                "Short-term training aligned with National Skills Qualification Framework (NSQF).",
                "Specialized courses in digital sales, solar panel installation, dairy processing, and apparel.",
                "Recognition of Prior Learning (RPL) to certify experienced village artisans.",
                "Direct job fairs (Rozgar Melas) and entrepreneurship counseling support."
            ],
            officialPortalName: "skillindia.gov.in",
            officialUrl: "https://www.skillindia.gov.in",
            officialUrlAdvice: "Enroll at your nearest Pradhan Mantri Kaushal Kendra (PMKK) or check course listings on www.skillindia.gov.in."
        }
    ],

    products: [
        {
            id: "p-1",
            name: "Handmade Bamboo Basket",
            price: 450,
            category: "Handicraft",
            description: "Natural eco-friendly cane basket handwoven by village artisans. Ideal for storage, fruit display, and sustainable home decor.",
            emoji: "🧺",
            origin: "Crafted by Sonali Gramin SHG, Kolhapur"
        },
        {
            id: "p-2",
            name: "Pure Forest Organic Honey",
            price: 350,
            category: "Food & Farm",
            description: "Raw, unprocessed wild forest honey extracted directly from bee-friendly tribal clusters. Zero artificial sugar or preservatives (500g).",
            emoji: "🍯",
            origin: "Sahyadri Agro Tribal Producer Co."
        },
        {
            id: "p-3",
            name: "Homemade Mango Pickle",
            price: 180,
            category: "Preserves",
            description: "Traditional grandmother recipe prepared with raw green mangoes, cold-pressed mustard oil, and ground aromatic spices (400g glass jar).",
            emoji: "🌶️",
            origin: "Annapurna Mahila Bachat Gat"
        },
        {
            id: "p-4",
            name: "Handmade Cloth Bag",
            price: 250,
            category: "Apparel",
            description: "Strong reusable double-stitched cotton khadi tote bag with ethnic block prints. Replaces single-use plastics effortlessly.",
            emoji: "👜",
            origin: "Gram Udyog Handloom Collective"
        }
    ],

    stories: [
        {
            id: "story-handicrafts",
            title: "Handmade Business Goes Digital",
            category: "Handicrafts & Decor",
            location: "Satara District",
            overview: "A small pottery workshop struggling with seasonal local sales transformed into an online craft studio reaching urban households across the state.",
            techSolution: "With assistance from a college student, they photographed their pottery using smartphones, set up a WhatsApp Business catalog, and began accepting UPI advance payments.",
            keyResults: [
                "Direct sales increased by 300% within 4 months.",
                "Shipped over 450 packages safely using India Post parcel tracking.",
                "Zero bad debts due to 100% upfront UPI transactions.",
                "Employed 6 additional village women for safe protective packaging."
            ],
            takeaway: "Demonstration Story: Demonstrates how smartphones and social catalogs bypass exploitative middle layers, directly returning fair value to rural artisans."
        },
        {
            id: "story-agriculture",
            title: "From Farm to Direct Customer",
            category: "Agriculture & Fresh Produce",
            location: "Ratnagiri District",
            overview: "An Alphonso mango grower bypassed wholesale APMC cartels by connecting directly with housing societies in Pune and Mumbai via digital group messaging.",
            techSolution: "Created a simple digital order sheet and shared weekly harvest updates on WhatsApp and Facebook. Offered cashless UPI QR payments upon doorstep courier delivery.",
            keyResults: [
                "Earned ₹850 per crate compared to ₹420 offered by mandi agents.",
                "Built an active WhatsApp buyer community of over 300 urban households.",
                "Received payment notifications instantly on phone via soundbox.",
                "Reduced fruit wastage to under 3% by harvesting only against confirmed pre-orders."
            ],
            takeaway: "Demonstration Story: Illustrates how direct digital marketing and instant payments empower farmers with predictable, dignified pricing."
        },
        {
            id: "story-food",
            title: "Traditional Spices & Pickles",
            category: "Food Processing",
            location: "Solapur District",
            overview: "A 10-woman self-help group producing roasted chili garlic chutney and traditional pickles expanded from village weekly bazaars into e-commerce delivery.",
            techSolution: "Standardized tamper-evident food-grade pouch packaging with clear ingredient labels, FSSAI registration QR, and digital social media promotions.",
            keyResults: [
                "Supplied products to 45 regional grocery shops and an online organic marketplace.",
                "Collective monthly income grew from ₹8,000 to over ₹65,000.",
                "Secured a ₹2 Lakh PMEGP credit-linked subsidy to buy an automated sealing machine.",
                "Established a verified business banking account with organized digital statements."
            ],
            takeaway: "Demonstration Story: Demonstrates how good packaging, digital verification, and government subsidies turn informal kitchen recipes into scalable rural brands."
        },
        {
            id: "story-women-enterprise",
            title: "Rural Weavers Collective",
            category: "Women-led Enterprise",
            location: "Paithan Cluster",
            overview: "Traditional handloom silk saree weavers utilized short online video stories to showcase the intricate 15-day weaving process to textile lovers worldwide.",
            techSolution: "Started posting 30-second reels documenting hand-weaving techniques, dye preparation, and artisan introductions. Added a clear QR code on saree tags linking to the weaver's story.",
            keyResults: [
                "Received custom pre-orders with 50% UPI advance payments 2 months in advance.",
                "Weaver wages doubled, reviving 14 idle village looms.",
                "Recognized with a PM Vishwakarma certification and toolkit voucher.",
                "Exported specialty stoles to international diaspora buyers through postal parcel."
            ],
            takeaway: "Demonstration Story: Demonstrates how authentic digital storytelling restores prestige and economic viability to traditional cultural craftsmanship."
        }
    ]
};

// ==========================================
// 2. ROUTER & SCREEN NAVIGATION STATE
// ==========================================
const AppState = {
    currentScreen: "splash",
    history: [],
    activeLesson: null,
    activeScheme: null,
    activeTab: "profit",
    isDesktopView: false
};

const screens = {
    splash: document.getElementById("screen-splash"),
    home: document.getElementById("screen-home"),
    learn: document.getElementById("screen-learn"),
    "lesson-detail": document.getElementById("screen-lesson-detail"),
    schemes: document.getElementById("screen-schemes"),
    "scheme-detail": document.getElementById("screen-scheme-detail"),
    tools: document.getElementById("screen-tools"),
    "sell-online": document.getElementById("screen-sell-online"),
    stories: document.getElementById("screen-stories"),
    profile: document.getElementById("screen-profile")
};

const topBar = document.getElementById("app-top-bar");
const topBarTitle = document.getElementById("top-bar-title");
const topBarSubtitle = document.getElementById("top-bar-subtitle");
const topBarBackBtn = document.getElementById("top-bar-back-btn");
const topBarBrandIcon = document.getElementById("top-bar-brand-icon");
const bottomNav = document.getElementById("app-bottom-nav");
const screenViewport = document.getElementById("screen-viewport");

function navigateTo(screenId, addToHistory = true) {
    if (AppState.currentScreen === screenId) return;

    if (addToHistory && AppState.currentScreen && AppState.currentScreen !== "splash") {
        AppState.history.push(AppState.currentScreen);
    }

    // Hide all screens
    Object.values(screens).forEach(screen => {
        if (screen) screen.classList.remove("active");
    });

    // Show target screen
    const target = screens[screenId];
    if (target) {
        target.classList.add("active");
        AppState.currentScreen = screenId;
        screenViewport.scrollTop = 0;
    }

    updateUIForScreen(screenId);
}

function goBack() {
    if (AppState.history.length > 0) {
        const prevScreen = AppState.history.pop();
        navigateTo(prevScreen, false);
    } else {
        navigateTo("home", false);
    }
}

function updateUIForScreen(screenId) {
    // Determine TopBar text & Back button visibility
    const isDetail = ["lesson-detail", "scheme-detail", "stories", "sell-online"].includes(screenId);
    const isSplash = screenId === "splash";

    if (isSplash) {
        topBar.style.display = "none";
        bottomNav.style.display = "none";
        return;
    }

    topBar.style.display = "flex";
    bottomNav.style.display = isDetail ? "none" : "flex";

    topBarBackBtn.style.display = isDetail ? "flex" : "none";
    topBarBrandIcon.style.display = isDetail ? "none" : "flex";

    // Set screen-specific header titles
    switch (screenId) {
        case "home":
            topBarTitle.textContent = "GramTech";
            topBarSubtitle.textContent = "Technology for Rural Startups";
            break;
        case "learn":
            topBarTitle.textContent = "Learn & Grow";
            topBarSubtitle.textContent = "Digital Literacy Lessons";
            break;
        case "lesson-detail":
            topBarTitle.textContent = AppState.activeLesson ? AppState.activeLesson.title : "Lesson Detail";
            topBarSubtitle.textContent = "Technology Lesson";
            break;
        case "schemes":
            topBarTitle.textContent = "Government Schemes";
            topBarSubtitle.textContent = "Business Support Directory";
            break;
        case "scheme-detail":
            topBarTitle.textContent = AppState.activeScheme ? AppState.activeScheme.shortName : "Scheme Detail";
            topBarSubtitle.textContent = "Government Support Scheme";
            break;
        case "tools":
            topBarTitle.textContent = "Business Tools";
            topBarSubtitle.textContent = "Financial Calculators";
            break;
        case "sell-online":
            topBarTitle.textContent = "Sell Online";
            topBarSubtitle.textContent = "E-Commerce Guide & Showcase";
            break;
        case "stories":
            topBarTitle.textContent = "Success Stories";
            topBarSubtitle.textContent = "Rural Startup Case Studies";
            break;
        case "profile":
            topBarTitle.textContent = "About GramTech";
            topBarSubtitle.textContent = "College CEP Project";
            break;
    }

    // Sync Bottom Navigation Active State
    document.querySelectorAll(".nav-item").forEach(item => {
        const navTarget = item.getAttribute("data-nav");
        if (navTarget === screenId) {
            item.classList.add("active");
        } else {
            item.classList.remove("active");
        }
    });
}

// ==========================================
// 3. POPULATE DYNAMIC LISTS (DOM Injections)
// ==========================================
function renderLessonsList() {
    const container = document.getElementById("lessons-list");
    if (!container) return;

    container.innerHTML = SampleData.lessons.map(lesson => `
        <div class="lesson-card" data-lesson-id="${lesson.id}">
            <div class="lesson-icon-circle">${lesson.icon}</div>
            <div class="lesson-meta">
                <h4>${lesson.title}</h4>
                <p>${lesson.subtitle}</p>
            </div>
            <span class="arrow-icon">›</span>
        </div>
    `).join("");

    container.querySelectorAll(".lesson-card").forEach(card => {
        card.addEventListener("click", () => {
            const lessonId = card.getAttribute("data-lesson-id");
            openLessonDetail(lessonId);
        });
    });
}

function openLessonDetail(lessonId) {
    const lesson = SampleData.lessons.find(l => l.id === lessonId);
    if (!lesson) return;

    AppState.activeLesson = lesson;

    document.getElementById("lesson-detail-title").textContent = lesson.title;
    document.getElementById("lesson-detail-subtitle").textContent = lesson.subtitle;
    document.getElementById("lesson-what-title").textContent = `What is ${lesson.title}?`;
    document.getElementById("lesson-what-desc").textContent = lesson.whatIsIt;
    document.getElementById("lesson-example-text").textContent = lesson.practicalExample;

    // Why list
    const whyList = document.getElementById("lesson-why-list");
    whyList.innerHTML = lesson.whyUseful.map(pt => `<li>${pt}</li>`).join("");

    // Key tips list
    const tipsList = document.getElementById("lesson-tips-list");
    tipsList.innerHTML = lesson.keyTips.map(tip => `<li>${tip}</li>`).join("");

    // Reset mark as read button
    const btnRead = document.getElementById("btn-mark-lesson-read");
    const badgeCompleted = document.getElementById("lesson-completed-badge");
    const readText = document.getElementById("btn-read-text");

    btnRead.classList.remove("completed");
    readText.textContent = "Mark as Read";
    badgeCompleted.style.display = "none";

    navigateTo("lesson-detail");
}

function renderSchemesList() {
    const container = document.getElementById("schemes-list");
    if (!container) return;

    container.innerHTML = SampleData.schemes.map(scheme => `
        <div class="scheme-card" data-scheme-id="${scheme.id}">
            <div class="scheme-card-head">
                <h4>${scheme.name}</h4>
                <span class="badge-pill">${scheme.category}</span>
            </div>
            <p class="tagline">${scheme.tagline}</p>
            <p class="purpose">${scheme.purpose}</p>
            <div class="scheme-card-foot">
                <span>View benefits & eligibility</span>
                <span class="arrow-icon">›</span>
            </div>
        </div>
    `).join("");

    container.querySelectorAll(".scheme-card").forEach(card => {
        card.addEventListener("click", () => {
            const schemeId = card.getAttribute("data-scheme-id");
            openSchemeDetail(schemeId);
        });
    });
}

function openSchemeDetail(schemeId) {
    const scheme = SampleData.schemes.find(s => s.id === schemeId);
    if (!scheme) return;

    AppState.activeScheme = scheme;

    document.getElementById("scheme-detail-category").textContent = scheme.category;
    document.getElementById("scheme-detail-name").textContent = scheme.name;
    document.getElementById("scheme-detail-tagline").textContent = scheme.tagline;
    document.getElementById("scheme-detail-purpose").textContent = scheme.purpose;
    document.getElementById("scheme-detail-beneficiaries").textContent = scheme.whoMayBenefit;
    document.getElementById("scheme-detail-finance").textContent = scheme.financialSupport;

    const featuresList = document.getElementById("scheme-features-list");
    featuresList.innerHTML = scheme.keyFeatures.map(f => `<li>${f}</li>`).join("");

    const portalLink = document.getElementById("scheme-portal-link");
    portalLink.href = scheme.officialUrl;

    navigateTo("scheme-detail");
}

function renderProductsList() {
    const container = document.getElementById("products-list");
    if (!container) return;

    container.innerHTML = SampleData.products.map(p => `
        <div class="product-card">
            <div class="product-emoji">${p.emoji}</div>
            <div class="product-meta">
                <div class="product-title-row">
                    <h5>${p.name}</h5>
                    <span class="product-price">₹${p.price}</span>
                </div>
                <p class="product-desc">${p.description}</p>
                <div class="product-origin">${p.origin}</div>
            </div>
        </div>
    `).join("");
}

function renderStoriesList() {
    const container = document.getElementById("stories-list");
    if (!container) return;

    container.innerHTML = SampleData.stories.map(s => `
        <div class="story-card">
            <div class="story-head">
                <div>
                    <h4>${s.title}</h4>
                    <span class="story-meta-sub">${s.category} • ${s.location}</span>
                </div>
                <span class="badge-pill">Demo Story</span>
            </div>
            <p class="story-desc">${s.overview}</p>
            <div class="story-tech-box">
                <strong>Technology Solution:</strong> ${s.techSolution}
            </div>
            <h5 class="story-results-title">Key Results Achieved:</h5>
            <ul class="checklist">
                ${s.keyResults.map(r => `<li>${r}</li>`).join("")}
            </ul>
            <div class="story-takeaway">${s.takeaway}</div>
        </div>
    `).join("");
}

// ==========================================
// 4. BUSINESS TOOLS (WORKING CALCULATORS)
// ==========================================
function setupCalculators() {
    // Tab switching
    document.querySelectorAll(".tool-tab").forEach(tab => {
        tab.addEventListener("click", () => {
            const tabName = tab.getAttribute("data-tab");
            document.querySelectorAll(".tool-tab").forEach(t => t.classList.remove("active"));
            tab.classList.add("active");

            document.querySelectorAll(".calculator-panel").forEach(p => p.classList.remove("active"));
            document.getElementById(`panel-${tabName}`).classList.add("active");
            AppState.activeTab = tabName;
        });
    });

    // 1. PROFIT CALCULATOR
    const btnProfit = document.getElementById("btn-calc-profit");
    const btnProfitDemo = document.getElementById("btn-profit-demo");
    const inputSp = document.getElementById("profit-sp");
    const inputCp = document.getElementById("profit-cp");
    const inputQty = document.getElementById("profit-qty");
    const profitErr = document.getElementById("profit-error");
    const profitResult = document.getElementById("profit-result");

    function calculateProfit() {
        const sp = parseFloat(inputSp.value);
        const cp = parseFloat(inputCp.value);
        const qty = parseFloat(inputQty.value);

        if (isNaN(sp) || isNaN(cp) || isNaN(qty) || inputSp.value.trim() === "" || inputCp.value.trim() === "" || inputQty.value.trim() === "") {
            profitErr.textContent = "Please enter all values.";
            profitResult.style.display = "none";
            return;
        }

        if (sp < 0 || cp < 0 || qty <= 0) {
            profitErr.textContent = "Please enter valid positive numbers.";
            profitResult.style.display = "none";
            return;
        }

        profitErr.textContent = "";
        const revenue = sp * qty;
        const cost = cp * qty;
        const profit = revenue - cost;
        const margin = revenue > 0 ? ((profit / revenue) * 100).toFixed(1) : 0;

        document.getElementById("profit-res-rev").textContent = `₹${revenue.toLocaleString("en-IN")}`;
        document.getElementById("profit-res-cost").textContent = `₹${cost.toLocaleString("en-IN")}`;
        
        const label = document.getElementById("profit-res-label");
        const val = document.getElementById("profit-res-val");
        const note = document.getElementById("profit-res-margin");

        if (profit >= 0) {
            label.textContent = "Net Profit:";
            val.textContent = `₹${profit.toLocaleString("en-IN")}`;
            val.style.color = "var(--primary)";
            note.textContent = `Formula: Profit = Revenue − Cost (${margin}% profit margin)`;
        } else {
            label.textContent = "Net Loss:";
            val.textContent = `-₹${Math.abs(profit).toLocaleString("en-IN")}`;
            val.style.color = "#d32f2f";
            note.textContent = `Formula: Cost exceeds revenue by ₹${Math.abs(profit).toLocaleString("en-IN")}`;
        }

        profitResult.style.display = "flex";
    }

    btnProfit.addEventListener("click", calculateProfit);

    btnProfitDemo.addEventListener("click", () => {
        inputSp.value = 500;
        inputCp.value = 300;
        inputQty.value = 10;
        calculateProfit();
    });

    // 2. EMI CALCULATOR
    const btnEmi = document.getElementById("btn-calc-emi");
    const inputEmiAmount = document.getElementById("emi-amount");
    const inputEmiRate = document.getElementById("emi-rate");
    const inputEmiTenure = document.getElementById("emi-tenure");
    const emiErr = document.getElementById("emi-error");
    const emiResult = document.getElementById("emi-result");

    btnEmi.addEventListener("click", () => {
        const p = parseFloat(inputEmiAmount.value);
        const annualRate = parseFloat(inputEmiRate.value);
        const tenureMonths = parseFloat(inputEmiTenure.value);

        if (isNaN(p) || isNaN(annualRate) || isNaN(tenureMonths)) {
            emiErr.textContent = "Please enter all values.";
            emiResult.style.display = "none";
            return;
        }

        if (p <= 0 || annualRate <= 0 || tenureMonths <= 0) {
            emiErr.textContent = "Please enter valid numbers.";
            emiResult.style.display = "none";
            return;
        }

        emiErr.textContent = "";
        const r = (annualRate / 12) / 100;
        const n = tenureMonths;
        const factor = Math.pow(1 + r, n);
        const emi = (p * r * factor) / (factor - 1);
        const totalPayment = emi * n;
        const totalInterest = totalPayment - p;

        document.getElementById("emi-res-monthly").textContent = `₹${Math.round(emi).toLocaleString("en-IN")} / month`;
        document.getElementById("emi-res-interest").textContent = `₹${Math.round(totalInterest).toLocaleString("en-IN")}`;
        document.getElementById("emi-res-total").textContent = `₹${Math.round(totalPayment).toLocaleString("en-IN")}`;

        emiResult.style.display = "flex";
    });

    // 3. SAVINGS CALCULATOR
    const btnSavings = document.getElementById("btn-calc-savings");
    const inputSavingsIncome = document.getElementById("savings-income");
    const inputSavingsExpenses = document.getElementById("savings-expenses");
    const savingsErr = document.getElementById("savings-error");
    const savingsResult = document.getElementById("savings-result");

    btnSavings.addEventListener("click", () => {
        const income = parseFloat(inputSavingsIncome.value);
        const expenses = parseFloat(inputSavingsExpenses.value);

        if (isNaN(income) || isNaN(expenses)) {
            savingsErr.textContent = "Please enter all values.";
            savingsResult.style.display = "none";
            return;
        }

        if (income < 0 || expenses < 0) {
            savingsErr.textContent = "Please enter valid positive numbers.";
            savingsResult.style.display = "none";
            return;
        }

        savingsErr.textContent = "";
        const savings = income - expenses;
        const savingsRatio = income > 0 ? ((savings / income) * 100).toFixed(1) : 0;
        const valElem = document.getElementById("savings-res-val");
        const noteElem = document.getElementById("savings-res-note");

        if (savings >= 0) {
            valElem.textContent = `₹${Math.round(savings).toLocaleString("en-IN")} / month`;
            valElem.style.color = "var(--primary)";
            noteElem.textContent = `Formula: Monthly Savings = Income − Expenses\nYou are saving ${savingsRatio}% of your monthly earnings.`;
        } else {
            valElem.textContent = `-₹${Math.round(Math.abs(savings)).toLocaleString("en-IN")} / month`;
            valElem.style.color = "#d32f2f";
            noteElem.textContent = `Formula: Monthly Savings = Income − Expenses\nExpenses exceed current income by ₹${Math.round(Math.abs(savings)).toLocaleString("en-IN")}.`;
        }

        savingsResult.style.display = "flex";
    });
}

// ==========================================
// 5. TOAST NOTIFICATION UTILITY
// ==========================================
function showToast(message) {
    const toast = document.getElementById("toast-popup");
    if (!toast) return;
    toast.textContent = message;
    toast.classList.add("show");
    setTimeout(() => {
        toast.classList.remove("show");
    }, 2400);
}

// ==========================================
// 6. INITIALIZATION & EVENT LISTENERS
// ==========================================
document.addEventListener("DOMContentLoaded", () => {
    // Render static data into DOM
    renderLessonsList();
    renderSchemesList();
    renderProductsList();
    renderStoriesList();
    setupCalculators();

    // 2-second splash screen auto transition
    let splashTimer = setTimeout(() => {
        navigateTo("home", false);
    }, 2000);

    // Skip splash button
    document.getElementById("btn-skip-splash").addEventListener("click", () => {
        clearTimeout(splashTimer);
        navigateTo("home", false);
    });

    // TopBar Back Button
    topBarBackBtn.addEventListener("click", goBack);

    // Bottom Navigation Bar Clicks
    document.querySelectorAll(".nav-item").forEach(item => {
        item.addEventListener("click", () => {
            const target = item.getAttribute("data-nav");
            navigateTo(target);
        });
    });

    // Home Screen Feature Card Clicks
    document.querySelectorAll(".feature-card").forEach(card => {
        card.addEventListener("click", () => {
            const target = card.getAttribute("data-target");
            navigateTo(target);
        });
    });

    // Hero Explore Now Button
    document.getElementById("btn-hero-explore").addEventListener("click", () => {
        navigateTo("learn");
    });

    // Stories Banner Click
    document.getElementById("banner-stories-link").addEventListener("click", () => {
        navigateTo("stories");
    });

    // Profile Screen Stories Link
    document.getElementById("btn-profile-stories").addEventListener("click", () => {
        navigateTo("stories");
    });

    // Mark as Read Button (Lesson Detail)
    document.getElementById("btn-mark-lesson-read").addEventListener("click", () => {
        const btn = document.getElementById("btn-mark-lesson-read");
        const readText = document.getElementById("btn-read-text");
        const badge = document.getElementById("lesson-completed-badge");

        readText.textContent = "Marked as Completed ✓";
        badge.style.display = "block";
        showToast("Lesson completed! ✓");
    });

    // Scheme Advisory Button (Alert Dialog)
    document.getElementById("btn-scheme-advisory").addEventListener("click", () => {
        if (!AppState.activeScheme) return;
        alert(
            `Official Portal Advisory:\n\n${AppState.activeScheme.officialUrlAdvice}\n\nOfficial Website: ${AppState.activeScheme.officialPortalName}\n\nDisclaimer: Scheme information is for educational purposes. Please verify current details on official government websites.`
        );
    });

    // Presentation Toolbar: Toggle View Mode (Phone Mockup vs Full Desktop)
    const btnToggleView = document.getElementById("btn-toggle-view");
    const deviceContainer = document.getElementById("device-container");
    const viewIcon = document.getElementById("view-icon");
    const viewLabel = document.getElementById("view-label");

    btnToggleView.addEventListener("click", () => {
        AppState.isDesktopView = !AppState.isDesktopView;
        if (AppState.isDesktopView) {
            deviceContainer.classList.add("desktop-mode");
            viewIcon.textContent = "💻";
            viewLabel.textContent = "Phone Mockup View";
        } else {
            deviceContainer.classList.remove("desktop-mode");
            viewIcon.textContent = "📱";
            viewLabel.textContent = "Desktop View";
        }
    });

    // Presentation Toolbar: Restart Demo
    document.getElementById("btn-restart-app").addEventListener("click", () => {
        AppState.history = [];
        navigateTo("splash", false);
        setTimeout(() => {
            navigateTo("home", false);
        }, 2000);
    });
});
