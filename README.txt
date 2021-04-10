CSE237: Programming Tools and Techniques
Members: Jack Cho, Jessica Wu, Ian Youth, Jaehwi Park
Project: Bear Banks

1.) What user stories were completed in this iteration?
	(A) A customer should be able to view their current account balance.
	(B) A customer should be able to withdraw cash from their account.
	(C) A customer should be able to deposit cash from their account.
	(D) An employee should be able to lock the ATM for use.
	(E) Both customers and employees should be able to go back a 
		page on any menu.
	(F) A customer should be able to input a pin number starting with 0
		and select an "un-selectable option" without crashing the system
		(i.e. user inputs for display options will be checked for correctness).
		
2.) What user stories do you intend to complete next iteration?
	(A) A customer should see a receipt when exiting the program that describes
		their transaction history (deposited $, withdrew $).
	(B) A customer should be able to cash a check after providing check-related
		information.
	(C) A customer should be able to view investment and banking recommendations
		based on the amount of money that they deposit.
		
3.) Is there anything that you implemented which doesn't currently work?
	(A) Everything that we have implemented, *when run correctly*, should
		execute without issue. However, we have not yet covered some cases
		where users provide input that is not expected.
		(i)	For example, when a user tries to withdraw or deposit cash,
			only integers are accepted; anything else for input will generate
			an error and cause the program to crash.
			
	(B)	All current menu options have been implemented.
		
4.) What commands are needed to compile and run your code from the command
	line (or better yet, provide a script that people can use to run your
	program!)
	(A) runBank.sh is the script needed to run our program. Just to clarify,
		everything should be run from the development branch.
		
		**IMPORTANT**
		On a Mac, ./runBank.sh has been executing correctly.
		On a Windows machine, ./runBank.sh has ALSO been executing correctly.
			*However, if you see the following error: "$'\r': command not found",
			try typing "dos2unix" and pressing enter and then retry "./runBank.sh".
			Alternatively, if you have Git Bash installed, you can run the program
			from there by typing "./runBank.sh".
		
******