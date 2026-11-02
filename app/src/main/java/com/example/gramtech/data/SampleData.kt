package com.example.gramtech.data

object SampleData {

    val lessons: List<Lesson> = listOf(
        Lesson(
            id = "digital-marketing",
            title = "Digital Marketing",
            subtitle = "Learn how social media can help promote your business.",
            iconName = "Campaign",
            summary = "Reach customers across villages and towns without high advertising budgets.",
            whatIsIt = "Digital marketing means using the internet, smartphones, and online platforms to present your products and services directly to potential buyers.",
            whyUseful = listOf(
                "Reach customers beyond your immediate local village market.",
                "Showcase product photos, videos, and customer reviews directly.",
                "Build trust and a recognizable brand name for your craft or farm.",
                "Receive instant customer inquiries directly on your phone.",
                "Increase sales with zero or very low advertising expenses."
            ),
            practicalExample = "A village artisan making terracotta pottery can click photos in natural sunlight, post them as WhatsApp Status and on Instagram, and receive orders from nearby district towns.",
            keyTips = listOf(
                "Post clear photos taken during daytime.",
                "Always mention product size, material, and price clearly.",
                "Respond quickly and politely to buyer inquiries.",
                "Ask satisfied customers to share your catalog with friends."
            )
        ),
        Lesson(
            id = "digital-payments",
            title = "Digital Payments",
            subtitle = "Learn about UPI, QR codes and safe digital payments.",
            iconName = "QrCode2",
            summary = "Accept payments seamlessly and keep a crystal clear digital account ledger.",
            whatIsIt = "Digital payments allow you to receive money directly into your bank account using UPI apps (PhonePe, Google Pay, Paytm, BHIM) and QR codes without needing physical cash or loose change.",
            whyUseful = listOf(
                "Eliminates the daily headache of finding loose cash and coins.",
                "Payments settle directly and instantly into your savings account.",
                "Creates an automatic digital bank statement that helps qualify for bank loans.",
                "Instant audio confirmation through UPI soundboxes avoids customer payment disputes.",
                "Allows distant customers to pay advance token amounts easily."
            ),
            practicalExample = "A village kirana store or tailoring shop prints a laminated UPI QR code standee. When customers scan and pay ₹150, the store owner gets instant SMS and audio notification.",
            keyTips = listOf(
                "Never share your UPI PIN or OTP with anyone claiming to send you money.",
                "Remember: Entering your UPI PIN always deducts money from your account, never deposits it.",
                "Verify the sender name and amount on your banking app before handing over goods.",
                "Download your monthly UPI transaction statement for business accounting."
            )
        ),
        Lesson(
            id = "social-media",
            title = "Social Media",
            subtitle = "Learn how WhatsApp, Facebook and Instagram can help your business.",
            iconName = "Share",
            summary = "Turn everyday chatting apps into powerful customer relationship channels.",
            whatIsIt = "Social media business channels enable rural entrepreneurs to maintain customer relationships, post new batch updates, and showcase production stories to genuine buyers.",
            whyUseful = listOf(
                "WhatsApp Business provides a free digital product catalog inside the app.",
                "Facebook community groups connect you with local and state-level buyer circles.",
                "Instagram Reels allow you to show behind-the-scenes making of authentic handmade items.",
                "Automated away messages and greeting messages keep your store active 24/7.",
                "Direct one-on-one conversation builds genuine trust with distant consumers."
            ),
            practicalExample = "A self-help group producing organic turmeric powder sets up a WhatsApp Business account with catalog items priced at ₹120 per 250g pack, enabling city buyers to order in 2 taps.",
            keyTips = listOf(
                "Install WhatsApp Business instead of regular WhatsApp to unlock catalog features.",
                "Set business working hours and an automatic greeting response.",
                "Post short 15-second videos showing raw ingredients and clean preparation.",
                "Keep customer numbers organized using labels like 'New Order', 'Paid', 'Dispatched'."
            )
        ),
        Lesson(
            id = "online-selling",
            title = "Online Selling",
            subtitle = "Learn how to sell products online.",
            iconName = "Storefront",
            summary = "Discover e-commerce channels, ONDC, and rural shipping partnerships.",
            whatIsIt = "Online selling involves listing your goods on digital platforms, online marketplaces, government portals, or direct social commerce so customers anywhere in India can purchase them.",
            whyUseful = listOf(
                "Breaks geographic barriers, allowing a remote village artisan to sell nationally.",
                "Cuts out exploitative middlemen who take large profit cuts.",
                "Receives prepaid orders or cash-on-delivery through trusted courier services.",
                "Enables participation in government-backed initiatives like ONDC and GeM.",
                "Allows selling high-margin seasonal specialties like festive sweets and harvest honey."
            ),
            practicalExample = "A cane weaver lists bamboo laundry baskets on an ONDC-enabled seller application and ships them using India Post Parcel service, earning ₹450 per unit compared to ₹180 from local traders.",
            keyTips = listOf(
                "Start small with 3 to 5 of your highest-demand products.",
                "Partner with local postal offices or parcel services for affordable transport.",
                "Use sturdy, moisture-proof packaging with bubble wrap or recycled cardboard.",
                "Always add a handwritten thank-you note inside the box to build repeat customers."
            )
        ),
        Lesson(
            id = "cyber-safety",
            title = "Cyber Safety",
            subtitle = "Learn how to protect yourself from online scams.",
            iconName = "Security",
            summary = "Crucial safety habits to protect your hard-earned business revenue from fraudsters.",
            whatIsIt = "Cyber safety encompasses essential security practices to protect your smartphone, bank accounts, UPI apps, and personal identity from cyber criminals and online fraudsters.",
            whyUseful = listOf(
                "Protects your business savings and daily earnings from fraudulent withdrawals.",
                "Prevents identity theft and misuse of your Aadhaar or PAN details.",
                "Guarantees that your online customer records and contacts stay secure.",
                "Ensures peace of mind while using modern digital banking and e-wallets.",
                "Helps you guide fellow village entrepreneurs against emerging fraudulent schemes."
            ),
            practicalExample = "A scammer calls claiming to be an army officer who wants to buy 50 jars of honey and sends a QR code asking the seller to scan it to 'receive' ₹10,000. The seller recognizes the scam and refuses.",
            keyTips = listOf(
                "Scanning a QR code or entering a PIN is ONLY for paying money, NEVER for receiving money.",
                "Never share 4-digit or 6-digit OTP codes received via SMS with any caller.",
                "Do not click on suspicious SMS links claiming 'Electricity disconnected' or 'Lottery won'.",
                "Lock your phone with a fingerprint or secure PIN code."
            )
        ),
        Lesson(
            id = "business-basics",
            title = "Business Basics",
            subtitle = "Learn simple concepts such as pricing, profit and expenses.",
            iconName = "AccountBalanceWallet",
            summary = "Fundamental bookkeeping and pricing wisdom to make your venture sustainable.",
            whatIsIt = "Business basics cover the simple arithmetic and financial disciplines needed to calculate actual production costs, set fair selling prices, and track true cash profit.",
            whyUseful = listOf(
                "Helps calculate true total cost (raw material + labor + packaging + travel).",
                "Ensures you do not underprice your valuable handcrafted labor.",
                "Maintains a clear distinction between personal household money and business money.",
                "Allows tracking monthly expenses to identify unnecessary leakages.",
                "Prepares your enterprise to present clear financial numbers when requesting bank credit."
            ),
            practicalExample = "If making a jar of pickle costs ₹70 in ingredients, ₹20 in glass jar and label, and ₹15 in labor/fuel (Total ₹105), selling at ₹180 leaves a solid ₹75 profit per jar.",
            keyTips = listOf(
                "Always pay yourself a fixed wage for your hours worked—labor is a true cost.",
                "Keep separate physical boxes or separate bank accounts for home and shop money.",
                "Write down daily sales and daily costs in a small register or smartphone notes app.",
                "Set aside 20% of profits every month to reinvest in bulk raw materials at cheaper rates."
            )
        )
    )

    val schemes: List<Scheme> = listOf(
        Scheme(
            id = "pm-mudra",
            name = "PM MUDRA Yojana",
            shortName = "MUDRA",
            tagline = "Funding the unfunded micro and small enterprises.",
            category = "Business Loan",
            purpose = "Provides collateral-free institutional credit up to ₹10 Lakhs to non-corporate, non-farm micro and small enterprises for income-generating activities.",
            whoMayBenefit = "Artisans, shopkeepers, fruit and vegetable vendors, food processors, repair shops, rural transport operators, and small manufacturing units.",
            financialSupport = "Three tiers: Shishu (up to ₹50,000), Kishore (₹50,000 to ₹5 Lakhs), and Tarun (₹5 Lakhs to ₹10 Lakhs).",
            keyFeatures = listOf(
                "No collateral or third-party guarantee required.",
                "No processing fee for Shishu and Kishore loan categories.",
                "MUDRA RuPay debit card provided for flexible working capital withdrawals.",
                "Repayment tenure up to 5 to 7 years with affordable interest rates."
            ),
            officialPortalName = "mudra.org.in / udyamimitra.in",
            officialUrlAdvice = "Visit your nearest public sector, regional rural (RRB), or cooperative bank branch, or apply online via www.udyamimitra.in.",
            officialUrl = "https://www.mudra.org.in"
        ),
        Scheme(
            id = "startup-india",
            name = "Startup India",
            shortName = "Startup India",
            tagline = "Building an inclusive national startup ecosystem.",
            category = "Incubation & Grants",
            purpose = "Fosters innovation, provides seed funding support, intellectual property facilitation, and simplifies regulatory compliance for newly incorporated startups.",
            whoMayBenefit = "Technology-enabled ventures, agri-tech startups, rural innovations, and product creators registered as LLP or Private Limited within 10 years.",
            financialSupport = "Startup India Seed Fund Scheme (SISFS) grants up to ₹20 Lakhs for proof-of-concept and up to ₹50 Lakhs for commercialization via incubators.",
            keyFeatures = listOf(
                "Income tax exemption for 3 consecutive years under section 80-IAC.",
                "80% rebate on patent filing fees and 50% on trademark filing.",
                "Fast-track government procurement exemptions on prior turnover.",
                "Access to free legal, mentoring, and investor pitch sessions."
            ),
            officialPortalName = "startupindia.gov.in",
            officialUrlAdvice = "Register your startup entity online on www.startupindia.gov.in and explore recognized incubators in your state.",
            officialUrl = "https://www.startupindia.gov.in"
        ),
        Scheme(
            id = "standup-india",
            name = "Stand-Up India",
            shortName = "Stand-Up India",
            tagline = "Promoting entrepreneurship among SC, ST & Women.",
            category = "Targeted Credit",
            purpose = "Facilitates bank loans between ₹10 Lakhs and ₹1 Crore to at least one Scheduled Caste (SC) or Scheduled Tribe (ST) borrower and at least one woman borrower per bank branch.",
            whoMayBenefit = "Women entrepreneurs and SC/ST individuals establishing greenfield (first-time) enterprises in manufacturing, services, agri-allied, or trading sectors.",
            financialSupport = "Composite loan (term loan + working capital) covering up to 85% of total project cost between ₹10 Lakhs and ₹100 Lakhs.",
            keyFeatures = listOf(
                "Specifically designated per commercial bank branch across India.",
                "Handholding support through Lead District Managers and SIDBI.",
                "Margin money requirement reduced to 15% with convergence of other subsidies.",
                "Repayable in 7 years with a moratorium period of up to 18 months."
            ),
            officialPortalName = "standupmitra.in",
            officialUrlAdvice = "Apply directly through the Stand-Up Mitra portal (www.standupmitra.in) or visit your local nationalized bank branch.",
            officialUrl = "https://www.standupmitra.in"
        ),
        Scheme(
            id = "pmegp",
            name = "PMEGP (Prime Minister Employment Generation)",
            shortName = "PMEGP",
            tagline = "Credit-linked capital subsidy for new micro-units.",
            category = "Govt Subsidy",
            purpose = "Generates continuous employment opportunities in rural and urban areas by helping traditional artisans and unemployed youth set up micro-enterprises.",
            whoMayBenefit = "Individuals aged 18+ with at least 8th standard pass for projects above ₹10 Lakhs (manufacturing) or ₹5 Lakhs (service). Self-help groups and cooperative societies also qualify.",
            financialSupport = "Project cost up to ₹50 Lakhs (manufacturing) and ₹20 Lakhs (services). Government subsidy ranges from 15% to 35% of project cost (higher in rural areas).",
            keyFeatures = listOf(
                "Substantial capital subsidy (up to 35% in rural areas for special categories).",
                "Administered at ground level by KVIC, KVIB, and District Industries Centres (DIC).",
                "Beneficiary contribution is only 5% to 10% of total project capital.",
                "Mandatory 10-day Entrepreneurship Development Programme (EDP) training."
            ),
            officialPortalName = "kviconline.gov.in/pmegpeportal",
            officialUrlAdvice = "Submit an online application via the KVIC e-portal (www.kviconline.gov.in) and coordinate with your District Industries Centre (DIC).",
            officialUrl = "https://www.kviconline.gov.in/pmegpeportal/"
        ),
        Scheme(
            id = "pm-vishwakarma",
            name = "PM Vishwakarma Scheme",
            shortName = "Vishwakarma",
            tagline = "Empowering traditional artisans and craftspeople.",
            category = "Artisan Upliftment",
            purpose = "Provides holistic end-to-end support to traditional artisans and craftspeople working with their hands and tools across 18 traditional trades.",
            whoMayBenefit = "Carpenters, boat makers, blacksmiths, armorers, locksmiths, potters, sculptors, cobblers, masons, basket/mat/broom makers, doll & toy makers, barbers, garland makers, washermen, tailors, and fishing net makers.",
            financialSupport = "Collateral-free enterprise credit up to ₹1 Lakh (Tier 1 at 5% concessional interest) and additional ₹2 Lakhs (Tier 2). Toolkit incentive of ₹15,000.",
            keyFeatures = listOf(
                "Official recognition as 'PM Vishwakarma' with certificate and ID card.",
                "5-7 days basic skill training with a daily stipend of ₹500.",
                "₹15,000 modern toolkit grant via e-voucher.",
                "Incentive for digital transactions (₹1 per transaction up to 100/month) and marketing support."
            ),
            officialPortalName = "pmvishwakarma.gov.in",
            officialUrlAdvice = "Register free of charge at any Common Services Centre (CSC) in your Gram Panchayat or on www.pmvishwakarma.gov.in.",
            officialUrl = "https://pmvishwakarma.gov.in"
        ),
        Scheme(
            id = "skill-india",
            name = "Skill India (PMKVY)",
            shortName = "Skill India",
            tagline = "Skill development and industry-ready training.",
            category = "Skill Training",
            purpose = "Empowers youth and rural entrepreneurs with industry-relevant skill training, digital literacy, and recognized certifications to improve livelihood avenues.",
            whoMayBenefit = "School/college dropouts, rural youth seeking self-employment, and existing workers wishing to assess and certify existing informal skills (RPL).",
            financialSupport = "100% government-sponsored free training, assessment fees covered, and monetary reward on successful certification.",
            keyFeatures = listOf(
                "Short-term training aligned with National Skills Qualification Framework (NSQF).",
                "Specialized courses in digital sales, solar panel installation, dairy processing, and apparel.",
                "Recognition of Prior Learning (RPL) to certify experienced village artisans.",
                "Direct job fairs (Rozgar Melas) and entrepreneurship counseling support."
            ),
            officialPortalName = "skillindia.gov.in / pmkvyofficial.org",
            officialUrlAdvice = "Enroll at your nearest Pradhan Mantri Kaushal Kendra (PMKK) or check course listings on www.skillindia.gov.in.",
            officialUrl = "https://www.skillindia.gov.in"
        )
    )


    val demoProducts: List<Product> = listOf(
        Product(
            id = "p-1",
            name = "Handmade Bamboo Basket",
            price = 450,
            category = "Handicraft",
            description = "Natural eco-friendly cane basket handwoven by village artisans. Ideal for storage, fruit display, and sustainable home decor.",
            emoji = "🧺",
            artisanOrigin = "Crafted by Sonali Gramin SHG, Kolhapur"
        ),
        Product(
            id = "p-2",
            name = "Pure Forest Organic Honey",
            price = 350,
            category = "Food & Farm",
            description = "Raw, unprocessed wild forest honey extracted directly from bee-friendly tribal clusters. Zero artificial sugar or preservatives (500g).",
            emoji = "🍯",
            artisanOrigin = "Sahyadri Agro Tribal Producer Co."
        ),
        Product(
            id = "p-3",
            name = "Homemade Mango Pickle",
            price = 180,
            category = "Preserves",
            description = "Traditional grandmother recipe prepared with raw green mangoes, cold-pressed mustard oil, and ground aromatic spices (400g glass jar).",
            emoji = "🌶",
            artisanOrigin = "Annapurna Mahila Bachat Gat"
        ),
        Product(
            id = "p-4",
            name = "Handmade Cloth Bag",
            price = 250,
            category = "Apparel",
            description = "Strong reusable double-stitched cotton khadi tote bag with ethnic block prints. Replaces single-use plastics effortlessly.",
            emoji = "👜",
            artisanOrigin = "Gram Udyog Handloom Collective"
        )
    )

    val successStories: List<SuccessStory> = listOf(
        SuccessStory(
            id = "story-handicrafts",
            title = "Handmade Business Goes Digital",
            category = "Handicrafts & Decor",
            entrepreneur = "Ramesh & Sunita Patil (Fictional Profile)",
            location = "Satara District",
            overview = "A small pottery workshop struggling with seasonal local sales transformed into an online craft studio reaching urban households across the state.",
            challenge = "Local village demand was stagnant, and city middlemen were paying barely ₹30 for decorative earthen pots that sold for ₹250 in urban malls.",
            techSolution = "With assistance from a college student, they photographed their pottery using smartphones, set up a WhatsApp Business catalog, and began accepting UPI advance payments.",
            keyResults = listOf(
                "Direct sales increased by 300% within 4 months.",
                "Shipped over 450 packages safely using India Post parcel tracking.",
                "Zero bad debts due to 100% upfront UPI transactions.",
                "Employed 6 additional village women for safe protective packaging."
            ),
            takeawayMessage = "Demonstration Story: Demonstrates how smartphones and social catalogs bypass exploitative middle layers, directly returning fair value to rural artisans."
        ),
        SuccessStory(
            id = "story-agriculture",
            title = "From Farm to Direct Customer",
            category = "Agriculture & Fresh Produce",
            entrepreneur = "Ganesh Jadhav (Fictional Profile)",
            location = "Ratnagiri District",
            overview = "An Alphonso mango grower bypassed wholesale APMC cartels by connecting directly with housing societies in Pune and Mumbai via digital group messaging.",
            challenge = "Wholesale agents deducted high commission fees and delayed payments for months, leaving farm margins dangerously thin.",
            techSolution = "Created a simple digital order sheet and shared weekly harvest updates on WhatsApp and Facebook. Offered cashless UPI QR payments upon doorstep courier delivery.",
            keyResults = listOf(
                "Earned ₹850 per crate compared to ₹420 offered by mandi agents.",
                "Built an active WhatsApp buyer community of over 300 urban households.",
                "Received payment notifications instantly on phone via soundbox.",
                "Reduced fruit wastage to under 3% by harvesting only against confirmed pre-orders."
            ),
            takeawayMessage = "Demonstration Story: Illustrates how direct digital marketing and instant payments empower farmers with predictable, dignified pricing."
        ),
        SuccessStory(
            id = "story-food",
            title = "Traditional Spices & Pickles",
            category = "Food Processing",
            entrepreneur = "Laxmi Self-Help Group (Fictional Profile)",
            location = "Solapur District",
            overview = "A 10-woman self-help group producing roasted chili garlic chutney and traditional pickles expanded from village weekly bazaars into e-commerce delivery.",
            challenge = "Glass jars often broke during rough transport, and lack of printed product information made outside customers hesitant to purchase.",
            techSolution = "Standardized tamper-evident food-grade pouch packaging with clear ingredient labels, FSSAI registration QR, and digital social media promotions.",
            keyResults = listOf(
                "Supplied products to 45 regional grocery shops and an online organic marketplace.",
                "Collective monthly income grew from ₹8,000 to over ₹65,000.",
                "Secured a ₹2 Lakh PMEGP credit-linked subsidy to buy an automated sealing machine.",
                "Established a verified business banking account with organized digital statements."
            ),
            takeawayMessage = "Demonstration Story: Demonstrates how good packaging, digital verification, and government subsidies turn informal kitchen recipes into scalable rural brands."
        ),
        SuccessStory(
            id = "story-women-enterprise",
            title = "Rural Weavers Collective",
            category = "Women-led Enterprise",
            entrepreneur = "Savita Shinde & Weavers (Fictional Profile)",
            location = "Paithan Cluster",
            overview = "Traditional handloom silk saree weavers utilized short online video stories to showcase the intricate 15-day weaving process to textile lovers worldwide.",
            challenge = "Master weavers were leaving handlooms to work as daily wage laborers because mass machine-made replicas flooded local shops.",
            techSolution = "Started posting 30-second reels documenting hand-weaving techniques, dye preparation, and artisan introductions. Added a clear QR code on saree tags linking to the weaver's story.",
            keyResults = listOf(
                "Received custom pre-orders with 50% UPI advance payments 2 months in advance.",
                "Weaver wages doubled, reviving 14 idle village looms.",
                "Recognized with a PM Vishwakarma certification and toolkit voucher.",
                "Exported specialty stoles to international diaspora buyers through postal parcel."
            ),
            takeawayMessage = "Demonstration Story: Demonstrates how authentic digital storytelling restores prestige and economic viability to traditional cultural craftsmanship."
        )
    )
}
