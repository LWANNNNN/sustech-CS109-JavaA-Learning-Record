# The Game of River Frontier: A Postmortem of the CS109 Course Project (Fall 2025)

**Development Team:** DevEason & LAWNNNNN
**Development Period:** October 26, 2025 – December 15, 2025
**Technical Stack:** Java (Swing) | IntelliJ IDEA | Maven, Git, Adobe Audition, Launch4j

**Article Length:** 1,490 words

**Estimated Reading Time:** 10 - 15 minutes

What began as a straightforward course requirement to implement Chinese Chess (Xiangqi) in Java evolved into a challenging seven-week development journey. This postmortem details the technical architecture, key challenges, and lessons learned from building “The Game of River Frontier.”

## 1. Project Origin & Technical Foundation

The project scope was defined by a rubric encompassing six core tasks, from basic move validation to advanced AI and networking features. 

<img src="file:///C:/Users/QRD/Desktop/打分表.png" title="" alt="打分表.png" width="667">

A foundational demo provided by professor offered a reference GUI framework and class structure. We made a strategic decision not to modify this demo directly. Instead, after studying it, we opted for a from-scratch implementation  - in a sense,"reinventing the wheel" for deeper learning. This approach, while increasing initial overhead, offered superior control over the codebase and facilitated a deeper understanding of the underlying systems required for a fully-featured board game.

**Technology Choices:** Java language was required. For the GUI, **Java Swing** was selected over JavaFX due to its maturity, stability, and the team’s familiarity, prioritizing robust functionality over advanced graphical effects. 

The toolchain was standardized: **Maven** for build automation and dependency management, **Git** for version control, **Adobe Audition** for audio asset processing, and **Launch4j** for generating a distributable Windows executable.

## **2. System Architecture & Core Implementation**

The application was structured into several packages following the separation of concerns principle.

### 2.1 Model Layer: Game State & Logic

The core game logic was encapsulated in the Model package. Each piece was implemented as a distinct object, containing its type, position, and rule-set—a clear application of object-oriented design. This included the validation logic for all standard moves and the implementation of complex draw conditions: **stalemate, threefold repetition, perpetual check, and dead position.** 

<img title="" src="file:///C:/Users/QRD/Desktop/将死.gif" alt="将死.gif" width="401">

![困毙.gif](C:\Users\QRD\Desktop\困毙.gif)

![平局.gif](C:\Users\QRD\Desktop\平局.gif)

Centralizing this logic ensured consistency across the game, AI, and network modules.

### 2.2 View/Controller Layer: Custom Swing GUI

A custom GUI was built on top of Swing to provide a polished user experience. Key enhancements included:

* **Visual Feedback:** Dynamic highlighting of selected pieces and legal moves, smooth animation for piece movement and capture.
  
  ![移动.gif](C:\Users\QRD\Desktop\移动.gif)

* **Modular Design:** Separate windows for login, gameplay, history, and settings, improving code maintainability.
  
  ![多windows.png](C:\Users\QRD\Desktop\多windows.png)

* **User Experience (UX):** Context-aware hints (e.g., highlighting the opponent’s last move), toggle-able password fields, and multiple visual themes (“skins”).
  
  ![密码.gif](C:\Users\QRD\Desktop\密码.gif)

### 2.3 Data Persistence & Game History

A secure and functional record system was a major focus. Game states were serialized into binary object files rather than plain text to deter tampering. The history system provided:

* **Automatic Archiving:** All local games were saved automatically.

* **Analytics:** Win/Loss/Draw statistics and a simple skill rating calculation.
  
  ![历史记录.gif](C:\Users\QRD\Desktop\历史记录.gif)

* **Replay Functionality:** Finished games could be replayed step-by-step, manually or automatically.
  
  ![replay.gif](C:\Users\QRD\Desktop\replay.gif)

* **Security:** Data integrity checks would force logout if corruption was detected.
  
  ![注销.png](C:\Users\QRD\Desktop\注销.png)

### 2.4 AI Engine: Minimax with Multi-Core Parallel Alpha-Beta Pruning

The AI opponent was built on a **minimax algorithm** with **alpha-beta pruning** for efficiency. To leverage modern CPUs, a multi-threaded search was implemented. The main technical hurdle was reconciling the inherently sequential nature of alpha-beta pruning with parallel execution. The solution involved a **shared “blackboard”** data structure to facilitate best-value propagation across threads, approximating a global pruning effect. Search depth was user-configurable (1-8 plies), with adaptive depth reduction in complex mid-game positions.

![lovegif_1769336396049.gif](C:\Users\QRD\Desktop\lovegif_1769336396049.gif)

![AI.gif](C:\Users\QRD\Desktop\AI.gif)

### 2.5 Network Module: LAN-Based P2P Play

A lightweight peer-to-peer system was developed for local network play. Each instance could host a game server or connect as a client to a peer’s IP address. 

![联网.gif](C:\Users\QRD\Desktop\联网.gif)

The system featured:

* **Heartbeat Detection:** To monitor connection liveness.

* **State Synchronization:** All game actions were serialized and transmitted in real-time to maintain both boards identical.
  
  ![LAN.gif](C:\Users\QRD\Desktop\LAN.gif)
  
  Limitation: The implementation was confined to LAN; a central server for WAN matchmaking was scoped out due to time constraints.

### 2.6 Audio System

Ambient background music and context-specific sound effects (move, capture, check, checkmate, game end) were integrated using an audio manager, significantly enhancing gameplay immersion.

## 3. Development Challenges & Iteration

The transition from prototype to stable application was the most demanding phase. Two critical issues illustrate the challenges faced:

* **Validation Logic Bug:** Early versions had incomplete move validation, where the front-end highlight logic diverged from the back-end rule checks. This occasionally allowed illegal moves that left the king in check. The fix required tighter integration between the UI controller and the core model’s validation methods.
* **AI-State Corruption Bug:** During testing, the AI would crash when the “undo” function was used in specific endgame scenarios. Debugging was difficult due to the complex interaction between the game state history stack and the AI’s internal board evaluation. We eventually located and fixed hundreds of problematic lines of code, turning the game from merely runnable to fully playable.

**Scope Management:** Adhering to the “core first” principle was vital. Advanced features like animated 3D pieces or a chess clock explicitly scoped out to ensure a stable and complete deliverable by the deadline.

## 4. Build, Deployment & Project Metrics

We used **Launch4j** to bundle the application into a single Windows `.exe`, and placed it together with a JRE file. This ensured compatibility on machines without a Java runtime. A noted constraint was that UI elements using absolute positioning could overflow on high-DPI displays (scaling >150%).

**Project Statistics:**

* Total Lines: 10,923 (Source: 8,541, Comments: 1,545)
* Number of Classes: 83
* Feature Completion: 100% of the assigned rubric.

The final defense lasted 25 minutes, with a demonstration focusing on AI and network gameplay. The implementation satisfied all core and partial advanced requirements.

![](C:\Users\QRD\AppData\Roaming\marktext\images\2026-01-25-18-23-27-局部截取_20260125_182303.png)

## 5. Gains: Growth Beyond Code

We came into this project with no prior experience in informatics competitions, and our grasp of Java was still foundational when the course began. The journey from that starting point to a completed application proved that with dedicated time and systematic effort, meaningful results are within reach. This experience reinforced a key lesson: **believe in the process, and the project will follow.**

### 5.1 Enhancement of Technical Capabilities

The development cycle—from initial architecture to final optimization—served as a practical immersion in several key areas. We strengthened our understanding of core Java concepts such as multithreading and object-oriented design principles. We also gained foundational experience in graphics programming and game logic implementation, while substantially improving our ability to debug complex issues and deconstruct problems methodically.

### 5.2 Insights into Engineering Practices

Working on a collaborative codebase underscored the non-negotiable role of tools like Git in modern software development. We recognized the long-term value of consistent code standards and comprehensive documentation—practices that are essential for maintainability. Furthermore, the project highlighted the importance of clear communication and workflow coordination, particularly when development responsibilities are divided across different layers of the application.

### 5.3 Summary of Project Experience

- Using Java for GUI programming is genuinely challenging — somewhat like trying to implement backend logic with HTML. 

- The initial phase involves navigating a wide array of components and event-driven patterns whose roles are not immediately obvious. The breakthrough comes from persistent engagement: tracing execution flows, mapping class relationships, and gradually internalizing the framework's structure. This understanding eventually enables you to build and extend your own systems effectively.

- A central takeaway was the critical importance of upfront architectural design. **Investing time in a flexible and coherent framework proved far more valuable than diving prematurely into implementation details.** Writing ‘clever’ but opaque code just to show off so-called 'expertise' is meaningless; true craftsmanship lies in creating solutions that are straightforward and maintainable. **As the saying goes: *The greatest truths are the simplest.* We firmly believe that truly good and healthy programs must be simple and easy to read.** 

## 6. Acknowledgements

We extend our sincere gratitude to Professor Yuxin Ma, Lab Teacher Shen Yun, and the teaching assistants for their guidance throughout the CS109 course.

**A special note of thanks to my partner, DevEason.** His technical insight, problem-solving tenacity, and collaborative spirit were instrumental in navigating the most difficult phases of this project. This successful outcome is a testament to effective teamwork.

**Acknowledgement for Development Tools:** 

We also extend our gratitude to the essential tools that supported this project. **Git** and **GitHub** formed the backbone of our version control and collaboration; **Maven** automated builds and dependency management; **Launch4j** provided a streamlined packaging solution. These tools significantly enhanced our development efficiency and project structure.

**Translation & Writing Aid Note:** 

During the drafting of this postmortem, **DeepSeek AI** was used to assist in polishing technical descriptions and verifying the accuracy of translation of specific academic terms.

*For access to the game executable and to try the game, please privately message the author to get the Baidu Cloud link password.* 

*Baidu Cloud link:  https://pan.baidu.com/s/12ddfxsZ6TKtzd_KyISiMkw*

# 楚河汉界：CS109课程项目（2025年秋季）开发后记

**开发团队：** DevEason & LAWNNNNN

**开发周期：** 2025年10月26日 – 2025年12月15日

**技术栈：** Java (Swing) | IntelliJ IDEA | Maven, Git, Adobe Audition, Launch4j

**文章字数：** 2485 词

**预计阅读时间：** 10 – 15 分钟

起初这只是一个用Java实现中国象棋的课程任务，最终却成为一段长达七周、充满挑战的开发历程。本文将对《楚河汉界》项目的技术架构、关键挑战与心得进行总结。

## 1. 项目背景与技术选型

项目要求涵盖六项核心任务，包括基础的走子验证到高级的AI与联机对战功能。

![打分表.png](C:\Users\QRD\Desktop\打分表.png)

教授提供的演示项目给出了GUI框架与类结构的参考。我们决定不直接在其基础上修改，而是选择在学习演示项目的基础上从头实现（算是某种意义上的自己造车轮）。这种做法虽然增加了前期工作量，但让我们对代码拥有更高掌控力，也更深入理解了实现一个完整棋盘游戏所需的底层逻辑。

**技术选择：** 项目要求使用Java。在GUI框架上，团队选择了**Java Swing**——它成熟、稳定，且我们更为熟悉，这有助于优先保证功能稳定性而非追求视觉效果。

我们建立了标准化工具链：**Maven**负责构建与依赖管理，**Git**用于版本控制，**Adobe Audition**处理音频素材，**Launch4j**则用于生成Windows可执行文件。

## **2. 系统架构与核心实现**

整个应用遵循关注点分离原则，按功能分包实现。

### 2.1 模型层：游戏状态与逻辑

核心游戏逻辑封装在Model包中。每个棋子都是一个独立对象，包含其类型、位置与规则集，这是面向对象设计的典型应用。这一层实现了所有标准走法验证，以及**困毙、三次重复、长将、僵局**等复杂和棋判定。

![将死.gif](C:\Users\QRD\Desktop\将死.gif)

![困毙.gif](C:\Users\QRD\Desktop\困毙.gif)

![平局.gif](C:\Users\QRD\Desktop\平局.gif)

将逻辑集中于此，确保了游戏、AI与联机对战模块间的一致性。

### 2.2 视图/控制器层：自定义Swing GUI

我们在Swing之上构建了自定义GUI，以提供更好的用户体验。主要改进包括：

- **视觉反馈：** 动态高亮选中棋子与合法落子点，实现棋子移动与吃子的平滑动画。
  
  ![移动.gif](C:\Users\QRD\Desktop\移动.gif)

- **模块化设计：** 登录、游戏、历史记录和设置均为独立窗口，提升了代码可维护性。
  
  ![多windows.png](C:\Users\QRD\Desktop\多windows.png)

- **用户体验（UX）：** 提供上下文提示（如高亮对手上一步）、密码显示切换、多种视觉主题（“皮肤”）等。
  
  ![密码.gif](C:\Users\QRD\Desktop\密码.gif)

### 2.3 数据储存与对战历史

我们重点构建了一套安全、实用的记录系统。对局状态被序列化为二进制文件（而非纯文本）以防止篡改。历史系统功能包括：

- **自动存档：** 所有本地对局自动保存。

- **数据分析：** 胜/负/平统计与简易等级分计算。
  
  ![历史记录.gif](C:\Users\QRD\Desktop\历史记录.gif)

- **对局回放：** 可逐步回放已完成的对局，支持手动与自动模式。
  
  ![replay.gif](C:\Users\QRD\Desktop\replay.gif)

- **安全性：** 数据完整性检查会在检测到损坏时强制注销账户。
  
  ![注销.png](C:\Users\QRD\Desktop\注销.png)

### 2.4 AI引擎：多核并行下Alpha-Beta剪枝的Minimax算法

AI对手基于**Minimax算法**，并采用**Alpha-Beta剪枝**以提高效率。为利用多核CPU，我们实现了多核优化（多线程搜索）。主要技术难点在于协调Alpha-Beta剪枝固有的顺序性与并行执行。解决方案是引入一个共享的**黑板**数据，在线程间传递最佳估值，近似实现全局剪枝效果。搜索深度可由用户配置（1-8层），并在复杂的局面中自适应降低或提高。

![lovegif_1769336396049.gif](C:\Users\QRD\Desktop\lovegif_1769336396049.gif)

![AI.gif](C:\Users\QRD\Desktop\AI.gif)

### 2.5 联机对战：局域网P2P对战

我们开发了一套轻量级点对点系统，支持局域网对战。每个程序实例既可以作为主机，也可以作为客户端连接至对方IP。

![联网.gif](C:\Users\QRD\Desktop\联网.gif)

该系统具备以下特性：

- **心跳检测：** 监控连接状态。

- **状态同步：** 所有游戏操作均被序列化并实时传输，确保双方棋盘状态完全一致。
  
  ![LAN.gif](C:\Users\QRD\Desktop\LAN.gif)
  
  **局限：** 实现仅限于局域网；因时间有限，未实现广域网匹配所需的中继服务器。

### 2.6 音频系统

通过一个音频管理器，我们集成了环境背景音乐与情境音效（走子、吃子、将军、绝杀、游戏结束），显著提升了游戏的沉浸感。

## 3. 开发挑战与迭代过程

从原型到稳定版本的过渡阶段最为艰难。以下两个关键问题体现了我们遇到的挑战：

- **验证逻辑漏洞：** 早期版本的前端高亮逻辑与后端规则检查存在不一致，偶尔会允许违规走子（如移动后己方王仍处于被将军状态，即送将）。修复方法是加强UI控制器与核心模型验证方法之间的整合。
- **AI状态损坏漏洞：** 测试中发现，在特定残局场景中使用“悔棋”功能会导致AI崩溃。由于游戏状态历史栈与AI内部棋盘评估之间存在复杂交互，调试过程非常困难。我们最终定位并修复了数百行问题代码，使游戏从“能运行”变为“真正可玩”。

**范围管理：** 坚持“核心优先”原则至关重要。我们明确将动画3D棋子、计时等高级功能排除在本次开发范围外，以确保在截止日期前交付一个稳定、完整、高质量的版本。

## 4. 构建、部署与项目数据

我们使用**Launch4j**将应用打包为单个Windows `.exe`文件，并附带JRE，以确保在没有Java运行环境的机器上也能使用。需注意，使用绝对定位的UI元素在高DPI显示器（缩放>150%）上可能出现显示溢出。

**项目数据：**

- 总代码行数：10,923 （源代码：8,541，注释：1,545）
- 类数量：83
- 功能完成度：100%覆盖课程要求。

最终答辩历时接近25分钟，演示重点展示了AI对战与网络对战功能。项目实现满足了所有核心与部分高级要求。

![局部截取_20260125_182303.png](C:\Users\QRD\Desktop\局部截取_20260125_182303.png)

## 5. 收获：代码之外的成长

我们两人此前并无信息学竞赛经验，课程初期连Java语法都没学完。从起点到完成一个完整应用的历程证明，项目就在那里，只要投入时间并系统性地努力，总能取得一些有意义的成果。

### 5.1 技术能力的提升

从架构设计到最终优化的完整开发周期，是一次对多项关键技术的深度实践。我们加强了对Java核心概念（如多线程、面向对象设计）的理解，获得了图形编程与游戏逻辑实现的基础经验，并大幅提升了系统化调试与分解复杂问题的能力。

### 5.2 对工程实践的体会

在协作代码库上工作，凸显了Git等版本控制工具在现代软件开发中不可替代的作用。我们认识到保持代码风格一致与编写完整注释对长期代码维护的价值。同时，项目也凸显了团队成员沟通与工作流协调的重要性，尤其是在开发职责按应用层次分工时。

### 5.3 项目经验小结

- 用Java做GUI编程确实很有挑战性——感觉有点像试图用HTML写后端逻辑。
- 起步学习阶段需要面对演示项目中的大量组件和类，而我们并不清楚他们的作用与联系。突破来自于持续投入：跟踪执行流、梳理类关系、逐步理解框架结构。最终，这种理解让我们有效地构建和扩展自己的系统。
- 核心体会是前期架构设计至关重要。**投入时间建立一个灵活、一致的框架，远比过早陷入实现细节更有价值。** 为了炫耀所谓的“技巧”而编写晦涩的“聪明”代码毫无意义；真正的技艺在于创造出清晰、可维护的解决方案。**正如那句格言：*大道至简。* 我们坚信，真正优秀、健康的程序总是简单易读的。**

## 6. 致谢

谨向马昱欣教授、实验教师沈韵以及助教学长致以诚挚谢意，感谢他们一路以来的指导。

**特别感谢我的搭档DevEason。** 他的技术洞察、解决问题的执着与协作精神，帮助我们度过了项目中最困难的阶段。最终的成果是高效团队合作的最好证明。

**开发工具致谢：** 同时，我们也感谢为本项目提供支持的必备工具。**Git**与**GitHub**构成了我们版本控制与协作的基石；**Maven**自动化了构建与依赖管理；**Launch4j**提供了便捷的打包方案。这些工具极大地提升并优化了我们的开发效率与项目结构。

**翻译与写作辅助说明：** 在撰写此篇后记时，我们使用了**DeepSeek AI**来协助润色技术描述并核对部分学术术语的翻译。

*如需获取游戏可执行文件并试玩，请私信作者索取百度网盘链接密码。*

*百度网盘链接：https://pan.baidu.com/s/12ddfxsZ6TKtzd_KyISiMkw*
