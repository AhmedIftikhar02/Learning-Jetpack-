Jetpack Compose Fast-Track Course
Overall Roadmap
DAY 1
│
├── 1. Compose Mental Model
├── 2. Basic UI & Layouts
├── 3. Modifiers
├── 4. State & Recomposition
├── 5. Lists & User Input
├── 6. Material 3 & Theming
├── 7. Navigation
└── 8. Small Practice App
        ↓
DAY 2
│
├── 9. State Management & ViewModel
├── 10. MVVM + Compose
├── 11. API + Repository + DI
├── 12. Room + Compose
├── 13. Side Effects & Coroutines
├── 14. Advanced UI & Performance
├── 15. Reusable Components
├── 16. Production Architecture
└── 17. Final Production App
PHASE 1: Compose Mental Model
1.1 What Actually Changes From XML?

You already know:

XML
   ↓
Activity / Fragment
   ↓
View
   ↓
findViewById / ViewBinding
   ↓
Update View manually

Compose:

Kotlin
   ↓
Composable Functions
   ↓
State
   ↓
Recomposition
   ↓
UI automatically updates

We will understand:

What @Composable means
Composition
Recomposition
Declarative UI
Composition lifecycle
Why Compose doesn't use XML
Why setContent {} exists
Compose vs traditional Views
Compose interoperability with XML
Practice

Build:

Hello Compose
     ↓
Text
     ↓
Button
     ↓
Counter

But we'll write it using professional structure, not everything inside MainActivity.

PHASE 2: Core UI

This is where we learn the actual Compose UI toolkit.

2.1 Basic Components
Text()
Button()
Icon()
Image()
Card()
Surface()
Divider()
Spacer()
2.2 Layouts

Learn:

Row
Column
Box
LazyColumn
LazyRow

And understand:

Alignment
Arrangement
Weight
FillMaxSize
FillMaxWidth
Padding
Spacing
2.3 Modifiers

This is extremely important.

You'll learn:

Modifier
    .fillMaxWidth()
    .padding()
    .background()
    .clickable()

And especially:

Modifier ordering matters.

We'll practice why:

Modifier
    .background()
    .padding()

can behave differently from:

Modifier
    .padding()
    .background()
PHASE 3: State & Recomposition

This is probably the most important Compose concept.

We'll deeply understand:

var count by remember { mutableStateOf(0) }

Then:

State concepts
remember
mutableStateOf
rememberSaveable
State hoisting
Stateless composables
Stateful composables
Recomposition
Smart recomposition
Unidirectional Data Flow

You'll learn this pattern:

        State
          ↓
       UI
          ↓
      Event
          ↓
     ViewModel
          ↓
    State Update
          ↓
       UI

This becomes the foundation for everything later.

PHASE 4: Forms & User Interaction

We'll build professional forms.

Topics:

TextField
OutlinedTextField
Button
Checkbox
RadioButton
Switch
Slider
Dropdown

We'll also learn:

Keyboard handling
Focus
IME actions
Form validation
Password fields
Error states
Loading states
Empty states
Practice

Build:

Login Screen

with:

Email
Password
Validation
Loading
Error
Success

But the UI will be designed in a reusable way.

PHASE 5: Lists & Real UI

You'll already know RecyclerView, so we'll translate that knowledge.

RecyclerView → Compose
RecyclerView
      ↓
LazyColumn

We'll learn:

LazyColumn
LazyRow
items
itemsIndexed
Stable keys
List state
Pagination
Pull-to-refresh
Empty list
Loading list
Error list
Practice

Build:

Product Listing

with:

LazyColumn
ProductCard
Loading
Empty
Error
Pagination

This will be our first real-world Compose screen.

PHASE 6: Material 3 & Theming

We'll learn modern Compose UI rather than old Material examples.

Topics:

Material 3
MaterialTheme
ColorScheme
Typography
Shapes
Dark theme
Light theme
Dynamic colors
Custom theme
Design system

We'll create:

ui/
 ├── theme/
 │    ├── Color.kt
 │    ├── Theme.kt
 │    └── Type.kt
 │
 └── components/

We'll also learn how to create a small reusable design system.

PHASE 7: Navigation

XML developers need to understand this transition properly.

We'll cover:

Navigation Compose

Topics:

NavHost
NavController
Routes
Arguments
Nested navigation
Bottom navigation
Back stack
Deep links
Navigation events
Passing data safely

We'll build:

Login
  ↓
Home
  ├── Details
  ├── Profile
  └── Settings
PHASE 8: ViewModel + Compose

Now we start connecting your existing professional Android knowledge with Compose.

You'll already know ViewModel.

We'll learn how Compose consumes it:

ViewModel
    ↓
UiState
    ↓
Composable

For example:

data class HomeUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)

Then:

ViewModel
      ↓
StateFlow<UiState>
      ↓
collectAsStateWithLifecycle()
      ↓
Composable

This is very important for production Compose.

PHASE 9: Side Effects

One of the biggest areas where new Compose developers get confused.

We'll properly understand:

LaunchedEffect
SideEffect
DisposableEffect
rememberCoroutineScope
produceState
derivedStateOf
snapshotFlow

And most importantly:

When should you use each one?

We'll practice real examples:

API call
Timer
Snackbar
Navigation event
Lifecycle listener
Analytics event
PHASE 10: Compose + MVVM + Clean Architecture

Now we'll combine everything you already know.

Architecture:

Presentation
     ↓
Domain
     ↓
Data

Example:

feature/
 └── home/
      ├── HomeScreen.kt
      ├── HomeViewModel.kt
      ├── HomeUiState.kt
      └── components/

Then:

HomeScreen
     ↓
HomeViewModel
     ↓
UseCase
     ↓
Repository
     ↓
Remote / Local

We'll discuss when a UseCase is actually useful and when adding one is just unnecessary abstraction.

PHASE 11: API Integration

Now we'll bring in your existing Retrofit knowledge.

Architecture:

Compose UI
    ↓
ViewModel
    ↓
UseCase
    ↓
Repository
    ↓
Retrofit
    ↓
API

We'll implement:

Retrofit
DTO
Mapper
Domain model
Repository
Result handling
Loading
Success
Error
Retry
Network error handling

And connect it to Compose.

PHASE 12: Room + Compose

You'll already know Room, so this will be relatively quick.

We'll cover:

Entity
DAO
Database
Repository
Flow
StateFlow
Compose

Important concept:

Room Flow
    ↓
ViewModel
    ↓
UiState
    ↓
Compose

We'll build a small offline-first feature.

PHASE 13: Dependency Injection

Since you already know Hilt, we'll focus on Compose-specific integration.

We'll use:

Hilt
ViewModel
Repository
UseCase
Retrofit
Room

We'll understand:

@HiltViewModel

and:

hiltViewModel()

plus proper dependency boundaries.

PHASE 14: Reusable Compose Components

This is where your professional-development mindset becomes important.

Instead of:

HomeScreen.kt
    ↓
500 lines of UI

we'll create:

ui/
 ├── components/
 │    ├── AppButton.kt
 │    ├── AppTextField.kt
 │    ├── LoadingView.kt
 │    ├── ErrorView.kt
 │    └── EmptyView.kt

Feature-specific components stay inside the feature:

feature/home/
 ├── HomeScreen.kt
 ├── HomeViewModel.kt
 └── components/
      ├── ProductCard.kt
      ├── CategoryItem.kt
      └── FeaturedSection.kt

We'll learn when to extract a composable and when not to.

PHASE 15: Advanced Compose

Once the fundamentals are solid, we'll move into:

Performance
Recomposition analysis
Stable vs unstable types
remember
derivedStateOf
key
Immutable state
Avoiding unnecessary recompositions
Lazy list optimization
Advanced UI
Animations
AnimatedVisibility
animate*AsState
updateTransition
Shared element concepts
Custom drawing
Canvas
Gestures
Nested scrolling
PHASE 16: Production-Level Compose

This is the part I want to emphasize for you.

We'll cover how modern professional projects are structured.

Example:

app/
│
├── core/
│   ├── common/
│   ├── network/
│   ├── database/
│   ├── designsystem/
│   └── navigation/
│
├── data/
│   ├── remote/
│   ├── local/
│   ├── repository/
│   └── mapper/
│
├── domain/
│   ├── model/
│   ├── repository/
│   └── usecase/
│
├── feature/
│   ├── auth/
│   ├── home/
│   ├── profile/
│   └── settings/
│
└── MainActivity.kt

But we'll also discuss feature-first architecture, because I don't want you blindly copying a folder structure.

We'll decide architecture based on:

Project size
Team size
Feature complexity
Code ownership
Reusability
Testing
Scalability
PHASE 17: Modern Production Patterns

Finally we'll cover the things you would actually encounter in a serious Compose project:

UI State
UiState
UiEvent
UiEffect
Unidirectional Data Flow
        ┌─────────────┐
        │  UI State   │
        └──────┬──────┘
               ↓
             UI
               ↓
            Event
               ↓
          ViewModel
               ↓
          Business Logic
               ↓
        New UI State
Other topics
State management
One-time events
Snackbar events
Navigation events
Lifecycle-aware collection
Paging 3
Pull-to-refresh
Error handling
Offline-first
Testing
UI testing
Preview
Accessibility
Adaptive layouts
Phone/tablet layouts
Configuration changes
Process death
Performance
Modularization
Final Project

Instead of doing 20 tiny useless examples, we'll build one proper production-style application throughout the course.

Something like:

Modern Compose App
│
├── Authentication
├── Home
├── Search
├── Details
├── Favorites
├── Profile
└── Settings

Architecture:

                Compose UI
                    │
                    ↓
              ViewModel
                    │
                    ↓
                UseCase
                    │
                    ↓
               Repository
                 /     \
                ↓       ↓
            Retrofit   Room
                │       │
                └───┬───┘
                    ↓
                 Models

With:

Kotlin
Jetpack Compose
Material 3
Navigation Compose
ViewModel
StateFlow
Coroutines
Hilt
Retrofit
Room
Paging
Clean Architecture
MVVM
UDF
Testing
Our Learning Method

This is important.

I won't just explain Compose syntax to you.

For every topic, we'll follow:

1. Concept
      ↓
2. Why it exists
      ↓
3. XML equivalent
      ↓
4. Compose approach
      ↓
5. Professional implementation
      ↓
6. Small exercise
      ↓
7. Real-world usage

For example, when we reach LazyColumn, I won't just tell you:

"LazyColumn is the Compose equivalent of RecyclerView."

We'll actually understand:

RecyclerView
Adapter
ViewHolder
DiffUtil
LayoutManager
        ↓
        ↓
LazyColumn
items()
key()
item()

and then build a production-quality list.

The 2-Day Schedule
🟢 Day 1: Compose Core
Order	Topic
1	Compose Mental Model
2	Composable Functions
3	Layouts
4	Modifiers
5	State
6	Recomposition
7	State Hoisting
8	Inputs & Forms
9	LazyColumn / LazyRow
10	Material 3
11	Navigation
12	Mini Project
🔵 Day 2: Production Compose
Order	Topic
13	ViewModel + StateFlow
14	Side Effects
15	MVVM + Compose
16	Clean Architecture
17	Retrofit
18	Room
19	Hilt
20	Reusable Components
21	Performance
22	Animations
23	Paging
24	Testing
25	Production Architecture
26	Final Project
One Important Rule

We will not treat Compose as a completely new Android world.

You already understand:

Activity
Fragment
Lifecycle
ViewModel
MVVM
Repository
Clean Architecture
Coroutine
Flow
Room
Retrofit
Hilt
Navigation

So I'll constantly map your existing knowledge:

XML concept       → Compose concept
RecyclerView      → LazyColumn
ViewBinding       → Composable functions
LiveData          → StateFlow
XML State         → Compose State
Fragment UI       → Screen Composable
Adapter            → items()
ViewModel         → ViewModel + UiState
Navigation        → Navigation Compose

That should make your transition much faster.