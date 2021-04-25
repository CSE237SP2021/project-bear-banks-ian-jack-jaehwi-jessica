CSE237: Programming Tools and Techniques
Members: Jack Cho, Jessica Wu, Ian Youth, Jaehwi Park
Project: Bear Banks

1.) What user stories were completed in this iteration?
	(A) A customer should see a receipt when exiting a program that
		describes their transaction history (deposits and withdrawals,
		and the amount of money involved in each transaction).
		
	(B) A customer should be able to view their account balance in terms
		of WashU meal points (gold, silver, and bronze plans).
		
	(C) A customer should be able to create a completely new account
		if for some reason they are dissatisfied with current one (i.e.
		incorrect name, undesirable pin number, etc.).
		
	(D) A customer should be able to view a list of WashU-related apparel
		that they can buy based on their final account balance.
		
2.) What user stories do you intend to complete next iteration?
	(A) Not applicable for this iteration.
		
3.) Is there anything that you implemented which doesn't currently work?
	(A) To the best of our knowledge, everything that we have implemented,
		when run correctly, should execute without issue. We believe that 
		we have covered all cases in which users provide input that is 
		not expected (i.e. string instead of integer, etc.). Appropriate
		error messages are displayed, and the user is prompted once more
		to provide input if necessary.
			
	(B)	All current menu options and user stories have been implemented.
		
4.) What commands are needed to compile and run your code from the command
	line (or better yet, provide a script that people can use to run your
	program!)
	(A) runBank.sh is the script needed to run our program.
		
		**IMPORTANT**
		On a Mac, ./runBank.sh has been executing correctly.
		On a Windows machine, ./runBank.sh has ALSO been executing correctly.
			*However, if you encounter the following error: "$'\r': command not found",
			try typing "dos2unix runBank.sh" and pressing enter and then retry "./runBank.sh".
			Alternatively, if you have Git Bash installed, you can run the program
			from there by typing "./runBank.sh".
		
******