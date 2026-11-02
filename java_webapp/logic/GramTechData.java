package logic;

/**
 * GramTechData provides all static data models and educational content
 * in Java for the RuralRise / GramTech web application.
 * Part of the College CEP Project: "Technology Support for Rural Startups".
 */
public class GramTechData {

    public static String getAllDataJson() {
        return "{\n" +
            "  \"appName\": \"RuralRise\",\n" +
            "  \"shortName\": \"GramTech\",\n" +
            "  \"subtitle\": \"Technology Support for Rural Startups\",\n" +
            "  \"projectTitle\": \"College CEP Project: Technology Support for Rural Startups\",\n" +
            "  \"version\": \"2.0 (Streamlined Edition)\",\n" +
            "  \"categories\": [\n" +
            "    {\"id\": \"all\", \"name\": \"All Topics\"},\n" +
            "    {\"id\": \"business\", \"name\": \"Business Basics\"},\n" +
            "    {\"id\": \"digital\", \"name\": \"Digital Skills\"},\n" +
            "    {\"id\": \"finance\", \"name\": \"Financial Awareness\"}\n" +
            "  ],\n" +
            "  \"resources\": [\n" +
            "    {\n" +
            "      \"id\": \"res-1\",\n" +
            "      \"category\": \"business\",\n" +
            "      \"title\": \"How to Start a Small Business\",\n" +
            "      \"desc\": \"Key steps for identifying village market needs, registering a trade name, and choosing the right rural enterprise model.\",\n" +
            "      \"tag\": \"Startup Basics\",\n" +
            "      \"readTime\": \"4 min read\",\n" +
            "      \"icon\": \"🚀\",\n" +
            "      \"summary\": \"Systematic steps to transform a rural business idea into a legal, sustainable venture.\",\n" +
            "      \"details\": \"Starting a rural venture begins with solving a genuine local problem—such as lack of cold storage, expensive transport, or missing grocery items. Choose an enterprise structure (sole proprietorship, partnership, or Self-Help Group), register for Udyam MSME certificate (free of cost), open a dedicated bank account, and establish supply contacts.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"res-2\",\n" +
            "      \"category\": \"business\",\n" +
            "      \"title\": \"Basic Business Planning\",\n" +
            "      \"desc\": \"Writing a straightforward 1-page business plan covering capital requirements, production timelines, and target buyers.\",\n" +
            "      \"tag\": \"Planning\",\n" +
            "      \"readTime\": \"5 min read\",\n" +
            "      \"icon\": \"📋\",\n" +
            "      \"summary\": \"A simple 1-page blueprint prevents expensive mistakes and clarifies your monthly profit targets.\",\n" +
            "      \"details\": \"A rural business plan needs 5 components: 1) What product or service are you selling? 2) Who are the target buyers (villagers, nearby town retail shops, or online)? 3) What is the startup capital needed for machinery/materials? 4) What are recurring monthly costs? 5) How many units must be sold monthly to break even?\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"res-3\",\n" +
            "      \"category\": \"business\",\n" +
            "      \"title\": \"Understanding Customers\",\n" +
            "      \"desc\": \"How to interview local and regional buyers to understand what products they genuinely want and what prices they pay.\",\n" +
            "      \"tag\": \"Market Research\",\n" +
            "      \"readTime\": \"3 min read\",\n" +
            "      \"icon\": \"🤝\",\n" +
            "      \"summary\": \"Never assume what buyers need; always observe and ask directly.\",\n" +
            "      \"details\": \"Visit weekly haats, talk with regional kirana shop owners, and interview at least 20 local consumers before spending money on inventory. Find out: Are they dissatisfied with existing quality? What price feels affordable? Would they buy in bulk if delivered to their doorstep?\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"res-4\",\n" +
            "      \"category\": \"business\",\n" +
            "      \"title\": \"Pricing Your Products\",\n" +
            "      \"desc\": \"Learn how to include raw material costs, artisan labor wages, fuel, and packaging to ensure healthy profit margins.\",\n" +
            "      \"tag\": \"Costing\",\n" +
            "      \"readTime\": \"4 min read\",\n" +
            "      \"icon\": \"🏷️\",\n" +
            "      \"summary\": \"Price your goods by adding all true input costs plus fair labor plus healthy profit margin.\",\n" +
            "      \"details\": \"Many rural craftspeople underprice because they treat their own time as zero cost. True Price = (Raw Materials + Packaging + Electricity/Fuel + Fair Daily Labor Wage + 20-30% Profit Margin). Check competitor prices in nearby towns to ensure your product remains competitive while remaining profitable.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"res-5\",\n" +
            "      \"category\": \"business\",\n" +
            "      \"title\": \"Managing Business Expenses\",\n" +
            "      \"desc\": \"Differentiating between personal household money and shop money, tracking daily cash flows, and avoiding wastage.\",\n" +
            "      \"tag\": \"Bookkeeping\",\n" +
            "      \"readTime\": \"3 min read\",\n" +
            "      \"icon\": \"📚\",\n" +
            "      \"summary\": \"Strictly separate domestic household cash from commercial working capital.\",\n" +
            "      \"details\": \"Use two separate registers or digital ledger apps: one for business purchases/sales and one for personal home expenses. Never dip into business sales cash for household groceries without recording an owner draw. This discipline protects working capital for restocking inventory.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"res-6\",\n" +
            "      \"category\": \"digital\",\n" +
            "      \"title\": \"Digital Marketing Basics\",\n" +
            "      \"desc\": \"Using everyday smartphones, photo editing, and messaging apps to promote village handcrafted and farm goods.\",\n" +
            "      \"tag\": \"Marketing\",\n" +
            "      \"readTime\": \"5 min read\",\n" +
            "      \"icon\": \"📢\",\n" +
            "      \"summary\": \"Reach hundreds of city buyers using free smartphone cameras and WhatsApp groups.\",\n" +
            "      \"details\": \"Take clean, high-resolution daylight photographs of your products against simple neutral backgrounds. Write clear product descriptions stating weight, materials, ingredients, and prices. Share posts in regional WhatsApp community groups, local Facebook pages, and college networks.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"res-7\",\n" +
            "      \"category\": \"digital\",\n" +
            "      \"title\": \"Social Media & WhatsApp Business\",\n" +
            "      \"desc\": \"Creating WhatsApp Business catalogs and sharing authentic behind-the-scenes production videos on Instagram reels.\",\n" +
            "      \"tag\": \"Social Commerce\",\n" +
            "      \"readTime\": \"4 min read\",\n" +
            "      \"icon\": \"💬\",\n" +
            "      \"summary\": \"Turn everyday messaging into a 24/7 digital storefront with instant ordering.\",\n" +
            "      \"details\": \"WhatsApp Business allows you to create an in-app product catalog with pictures, descriptions, and prices. Configure automated welcome messages, quick replies for frequent queries (e.g., shipping rates, payment QR), and organize buyer chats with tags like 'Order Received' and 'Shipped'.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"res-8\",\n" +
            "      \"category\": \"digital\",\n" +
            "      \"title\": \"Online Payments & UPI Safety\",\n" +
            "      \"desc\": \"Adopting QR code standees and soundboxes for instant bank settlements while avoiding OTP and phishing scams.\",\n" +
            "      \"tag\": \"Fintech & Safety\",\n" +
            "      \"readTime\": \"4 min read\",\n" +
            "      \"icon\": \"💳\",\n" +
            "      \"summary\": \"Accept payments effortlessly while keeping your bank balance completely secure.\",\n" +
            "      \"details\": \"Print a laminated UPI QR code connected directly to your business account. Golden rule of UPI: Entering your UPI PIN is ONLY done when YOU are SENDING money, NEVER when RECEIVING money. Never click unknown SMS links and never share one-time passwords (OTP) with callers.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"res-9\",\n" +
            "      \"category\": \"digital\",\n" +
            "      \"title\": \"Google Business & Local Visibility\",\n" +
            "      \"desc\": \"Setting up a Google Business profile with your address, contact numbers, and opening hours so regional travelers find you.\",\n" +
            "      \"tag\": \"Local SEO\",\n" +
            "      \"readTime\": \"3 min read\",\n" +
            "      \"icon\": \"📍\",\n" +
            "      \"summary\": \"Put your shop or workshop on Google Maps so travelers and town customers discover you.\",\n" +
            "      \"details\": \"Create a free Google Business Profile with your workshop location, operating hours, phone number, and product photos. Encourage satisfied travelers and visitors to leave 5-star Google reviews. This drives direct highway traffic and wholesale buyer visits.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"res-10\",\n" +
            "      \"category\": \"finance\",\n" +
            "      \"title\": \"Understanding Startup Costs\",\n" +
            "      \"desc\": \"Distinguishing between one-time fixed capital (tools, equipment) and recurring working capital (ingredients, wages).\",\n" +
            "      \"tag\": \"Budgeting\",\n" +
            "      \"readTime\": \"4 min read\",\n" +
            "      \"icon\": \"💰\",\n" +
            "      \"summary\": \"Calculate fixed capital vs working capital before launching commercial production.\",\n" +
            "      \"details\": \"Fixed capital includes machines, sheds, and equipment that last for years. Working capital is the rolling cash needed for 2-3 months of raw materials, packaging, electricity, and transport before customer sales revenue starts flowing back in.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"res-11\",\n" +
            "      \"category\": \"finance\",\n" +
            "      \"title\": \"Loan Awareness & Credit Health\",\n" +
            "      \"desc\": \"How maintaining a digital bank transaction statement helps small entrepreneurs secure bank loans with lower interest.\",\n" +
            "      \"tag\": \"Credit Health\",\n" +
            "      \"readTime\": \"5 min read\",\n" +
            "      \"icon\": \"📈\",\n" +
            "      \"summary\": \"Build a strong banking track record to qualify for low-interest formal credit.\",\n" +
            "      \"details\": \"Banks approve loans based on proof of cash flow. Depositing cash sales regularly into your account and accepting UPI payments builds a verifiable digital bank statement. Repay small credit lines on time to maintain a solid credit score.\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"businessIdeas\": [\n" +
            "    {\n" +
            "      \"id\": \"idea-1\",\n" +
            "      \"title\": \"Organic Farming & Direct Sales\",\n" +
            "      \"desc\": \"Chemical-free vegetable and fruit cultivation with direct-to-consumer digital subscription models in nearby towns.\",\n" +
            "      \"skills\": \"Crop planning, organic soil preparation, grading, packaging.\",\n" +
            "      \"technology\": \"WhatsApp buyer groups, UPI payments, weather forecast mobile apps.\",\n" +
            "      \"icon\": \"🌱\",\n" +
            "      \"investment\": \"Low to Medium\",\n" +
            "      \"details\": \"Bypasses mandi middlemen by delivering weekly vegetable baskets directly to apartment societies in neighboring cities. Advance payments received via UPI QR codes provide steady cash flow.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"idea-2\",\n" +
            "      \"title\": \"Food Processing & Pickles\",\n" +
            "      \"desc\": \"Value-addition to raw farm produce by processing mangoes, amla, chilies, and grains into standardized snacks and pickles.\",\n" +
            "      \"skills\": \"Traditional recipe formulation, hygienic packaging, quality control.\",\n" +
            "      \"technology\": \"Tamper-evident heat sealers, FSSAI digital registration, Instagram Reels.\",\n" +
            "      \"icon\": \"🍯\",\n" +
            "      \"investment\": \"Medium\",\n" +
            "      \"details\": \"Raw harvest prices fluctuate heavily. Transforming fruit into packaged pickles, jams, or roasted spice mixes triples the shelf life and yields 40% higher net margins per kilogram.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"idea-3\",\n" +
            "      \"title\": \"Handicrafts & Artisanal Decor\",\n" +
            "      \"desc\": \"Selling traditional village cane weaving, pottery, and handloom fabrics through online digital marketplaces and social commerce.\",\n" +
            "      \"skills\": \"Artisan craftsmanship, product design consistency, protective boxing.\",\n" +
            "      \"technology\": \"Digital smartphone photography, ONDC e-commerce catalogs, India Post tracking.\",\n" +
            "      \"icon\": \"🧺\",\n" +
            "      \"investment\": \"Low\",\n" +
            "      \"details\": \"Urban buyers value authentic handmade goods. Using clean daylight photography and sharing artisan story videos elevates products from village weekly markets to high-value gifting items.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"idea-4\",\n" +
            "      \"title\": \"Smart Dairy Management\",\n" +
            "      \"desc\": \"Micro-dairy setup utilizing digital milk analyzers, automated milking stations, and cold-chain supply coordination.\",\n" +
            "      \"skills\": \"Animal husbandry, fodder nutrition, hygiene protocols.\",\n" +
            "      \"technology\": \"Digital fat/SNF testers, cattle health tracking apps, automated SMS dairy ledger.\",\n" +
            "      \"icon\": \"🥛\",\n" +
            "      \"investment\": \"Medium to High\",\n" +
            "      \"details\": \"Transparent digital milk testing ensures farmers receive fair rates based on butterfat content. Milk collection points credit funds directly to bank accounts every 10 days.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"idea-5\",\n" +
            "      \"title\": \"Rural Tourism & Farmstays\",\n" +
            "      \"desc\": \"Hosting urban families and educational tours to experience village culture, traditional cuisine, and farm harvests.\",\n" +
            "      \"skills\": \"Hospitality, tour curation, local folklore storytelling.\",\n" +
            "      \"technology\": \"Google Maps listings, Airbnb/rural portals, digital advance booking.\",\n" +
            "      \"icon\": \"🏡\",\n" +
            "      \"investment\": \"Medium\",\n" +
            "      \"details\": \"City residents eagerly seek peaceful weekend getaways. A tidy farmstay offering bullock cart rides and home-cooked organic meals generates substantial non-farm income.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"idea-6\",\n" +
            "      \"title\": \"Agricultural Equipment Rental\",\n" +
            "      \"desc\": \"Custom Hiring Centre (CHC) offering small farmers shared access to mini tractors, solar pumps, and power weeders.\",\n" +
            "      \"skills\": \"Machinery maintenance, scheduling, field operations.\",\n" +
            "      \"technology\": \"Mobile booking registers, digital time logs, GPS equipment tracking.\",\n" +
            "      \"icon\": \"🚜\",\n" +
            "      \"investment\": \"High\",\n" +
            "      \"details\": \"Smallholder farmers cannot afford expensive machinery. Hiring equipment at hourly rates saves farmers money while providing the entrepreneur steady seasonal rental revenue.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"idea-7\",\n" +
            "      \"title\": \"Rural Courier & Last-Mile Delivery\",\n" +
            "      \"desc\": \"Hub-and-spoke distribution network connecting village clusters with district parcel centers for e-commerce deliveries.\",\n" +
            "      \"skills\": \"Route optimization, inventory verification, customer service.\",\n" +
            "      \"technology\": \"Delivery tracking apps, digital signature capture, UPI soundbox.\",\n" +
            "      \"icon\": \"🚚\",\n" +
            "      \"investment\": \"Low\",\n" +
            "      \"details\": \"Major e-commerce companies and medicine distributors struggle with rural addresses. A local village entrepreneur acts as a trusted parcel pickup and delivery hub.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"idea-8\",\n" +
            "      \"title\": \"Digital Village Service Center\",\n" +
            "      \"desc\": \"Single-window rural center providing Aadhaar services, certificate applications, printouts, and digital literacy assistance.\",\n" +
            "      \"skills\": \"Computer literacy, document processing, patience in guiding elders.\",\n" +
            "      \"technology\": \"Desktop PC, scanner/printer, biometric fingerprint scanner, high-speed broadband.\",\n" +
            "      \"icon\": \"💻\",\n" +
            "      \"investment\": \"Low to Medium\",\n" +
            "      \"details\": \"Saves village residents from traveling 25 kilometers to the district headquarters for utility bill payments, certificate applications, and scholarship filings.\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"digitalTools\": [\n" +
            "    {\n" +
            "      \"category\": \"Communication\",\n" +
            "      \"icon\": \"💬\",\n" +
            "      \"tools\": [\"WhatsApp Business\", \"Voice & Video Calls\", \"Email\"],\n" +
            "      \"whatItDoes\": \"Enables instant real-time messaging, multimedia sharing, automated welcome replies, and catalog displays directly on mobile devices.\",\n" +
            "      \"howItHelps\": \"Allows a village artisan or producer to chat with hundreds of prospective buyers simultaneously without expensive office infrastructure.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"category\": \"Marketing\",\n" +
            "      \"icon\": \"📢\",\n" +
            "      \"tools\": [\"Instagram Reels\", \"Facebook Groups\", \"Canva Graphic Creator\"],\n" +
            "      \"whatItDoes\": \"Tools to design digital promotional posters, upload high-definition video clips, and connect with regional consumer groups.\",\n" +
            "      \"howItHelps\": \"Bypasses costly newspaper ads, allowing small startups to build brand awareness virally across state borders for free.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"category\": \"Payments\",\n" +
            "      \"icon\": \"💳\",\n" +
            "      \"tools\": [\"UPI QR Codes\", \"BHIM / PhonePe / GPay\", \"UPI Soundbox\"],\n" +
            "      \"whatItDoes\": \"Facilitates instant zero-fee account-to-account funds transfer with immediate audio and SMS receipt confirmations.\",\n" +
            "      \"howItHelps\": \"Eliminates loose change hassles, guarantees instant receipt of advance payments, and generates bank statements to qualify for loans.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"category\": \"Productivity\",\n" +
            "      \"icon\": \"📊\",\n" +
            "      \"tools\": [\"Google Sheets / Excel\", \"Digital Ledger (Khata App)\", \"Cloud Drive\"],\n" +
            "      \"whatItDoes\": \"Replaces paper registers with auto-calculating spreadsheets, digital debt tracking, and secure document cloud backups.\",\n" +
            "      \"howItHelps\": \"Keeps track of customer credit without missing entries and protects vital tax/registration receipts against physical damage or loss.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"category\": \"Learning\",\n" +
            "      \"icon\": \"🎓\",\n" +
            "      \"tools\": [\"YouTube Tutorials\", \"Kisan Suvidha App\", \"Skill India Portal\"],\n" +
            "      \"whatItDoes\": \"Free video-based learning hubs covering pest management, food processing protocols, machine maintenance, and pricing techniques.\",\n" +
            "      \"howItHelps\": \"Empowers rural youth to self-train in advanced techniques from top agricultural universities without leaving their village.\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"faqs\": [\n" +
            "    {\n" +
            "      \"q\": \"What is RuralRise / GramTech?\",\n" +
            "      \"a\": \"RuralRise is a student-developed educational prototype created for a college CEP project on 'Technology Support for Rural Startups'. It demonstrates how digital tools, knowledge modules, and business blueprints empower rural entrepreneurs.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"q\": \"Who can use RuralRise?\",\n" +
            "      \"a\": \"It is designed for rural entrepreneurs, students, SHG members, small farmers, and village innovators seeking practical business and digital skills guidance.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"q\": \"Does this website require an account or login?\",\n" +
            "      \"a\": \"No. The application is completely open-access and operates with zero authentication or login barriers to allow effortless demonstration during college evaluations.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"q\": \"Is user information stored in a database?\",\n" +
            "      \"a\": \"No. The project operates 100% locally with static data. No database, server tracking, or user information collection is performed.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"q\": \"How is this application powered by Java?\",\n" +
            "      \"a\": \"The web application is served by a lightweight native Java HTTP server (com.sun.net.httpserver.HttpServer) that serves the startup knowledge repository and web assets.\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    }
}
