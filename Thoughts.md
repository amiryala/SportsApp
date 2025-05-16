# Thoughts

Please take a couple minutes to provide brief answers to the following questions. Your responses will help us better understand your thought process and approach to the assignment.

1. Can you describe your approach to tackling this assessment, including any key decisions or trade-offs you made during the process?
   - I first took care of the obvious crash - the app was missing the INTERNET permission in the manifest 
   (it was commented out). Then I focused on making the list scrollable by switching from Column to LazyColumn, 
   which is the correct component for scrolling lists in Compose.
   
   - For showing teams when leagues are clicked, I decided to go with an expandable approach where teams 
   appear under the selected league. I had to think about whether to make a separate screen or keep it 
   all in one list, but keeping it in one list seemed to be the quicker and maybe even more user-friendly.
   
   - For the optional tasks, I prioritized architecture first because a good foundation makes everything 
   else easier. I went with MVVM + Clean Architecture with three main layers: data, domain, and presentation. 
   This separation makes the code more maintainable but adds more boilerplate.
   
   - For DI, I chose Hilt since it's the recommended solution from Google and simpler than manual DI 
   or Dagger. For UI improvements, I focused on making the app look more polished with cards, animations, 
   and better state handling rather than completely redesigning the flow.
   
   - There was definitely a trade-off between adding all these features and keeping the code simple enough
   to finish in 2 hours. I had to balance being thorough with being practical.

2. If you had additional time, what improvements, features, or refinements would you have prioritized for this project, and why?
   
    With more time, I'd definitely add the following:

    - Testing! I'd add unit tests for the viewmodel and repository, and UI tests for the main 
   interactions. Without tests, we can't be confident in our refactoring.

    - Better error handling with specific error states and retry mechanisms. The current implementation just shows a generic error.

    - Better animations and transitions between states.

    - Team details screen with more info about each team, maybe photos and stats.

    - Search functionality for leagues and teams.