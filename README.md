# AndroidTDD

Sample app with basic settings to start developing an app with unit test included. This application only demonstrates the use of Robolectric and Mockito.

# Getting Started

1. Clone the repo to your local development machine.
2. Import the app using the build.gradle file in the root folder.
3. Add unit test in the build varians tab in android studio. At this point Android Studio will detect the test folder located at src.
4. Add a new JUnit configuration
	4.1. Assign a name to the configuration (Use a self explanatory name for each test file. eg. MainActivityTest)
	4.2. Choose app as module.
	4.3. Select MainActivityTest as test class.
	4.4. Add $MODULE_DIR$ as working directory, otherwise Robolectric will through an error (Only for mac users).
	4.5. Click on Apply then OK.
5. Run the configuration that you've just created.

There is also a Test for the EmailValidator utils file. To run the test follow the same procedure as before, but select EmailValidatorTest class.

# Additional Commments

The main idea behind this repo is to set a clean start for every user that intends to start writing apps with tests that validate functionality through a project lifetime.

Feel free to contribute and add additional test cases that were not included here.

# TODO

Some additional test cases can involve networking, Location APIs and layout tests for example.



