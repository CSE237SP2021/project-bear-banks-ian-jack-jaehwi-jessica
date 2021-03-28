CSE237: Programming Tools and Techniques
Project: Bear Banks
Members: Jack Cho, Jessica Wu, Ian Youth, Jaehwi Park

1.) What user stories were completed in this iteration?
	(A) A customer should be able to access their menu of options.
	(B) An employee should be able to access their menu of options.
	(C) A customer should be able to open an account.
	(D) A customer should be able to specify details when opening their account
		(i.e. account name and pin number).
		
2.) What user stories do you intend to complete next iteration?
	(A) A customer should be able to view their current account balance.
	(B) A customer should be able to withdraw cash from their account.
	(C) A customer should be able to deposit cash from their account.
	(D) An employee should be able to lock the ATM for use.
	(E) Both customers and employees should be able to go back a 
		page on any menu.
		
3.) Is there anything that you implemented which doesn't currently work?
	(A) Everything that we have implemented, *when run correctly*, should
		execute without issue. However, we have not yet covered some cases
		where users provide input that is not expected.
		(i)	For example, any time that the program requires an integer,
			the user *must* input an integer; otherwise, an exception
			will be thrown.
		(ii)	However, we do catch errors like inputting an incorrect menu
				option.
		(iii)	We also have unit tests that verify that we are catching
				incorrectly formatted PIN numbers correctly. This makes
				it so that we only accept positive, four-digit integers
				as PIN numbers.
	(B)	Any menu options that have not been fully implemented terminate
		after the user selects them (with a corresponding message).
		
4.) What commands are needed to compile and run your code from the command
	line (or better yet, provide a script that people can use to run your
	program!)
	(A) runBank.sh is the script needed to run our program. Just to clarify,
		everything should be run from the development branch.
		
******