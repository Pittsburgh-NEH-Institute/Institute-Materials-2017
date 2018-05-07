# Don't panic: interpretation of error messages

## Reading stack traces in Python

### What are stack traces?


A **stack trace** is a type of error report produced by Python and other programming languages that shows the chain of events between an error and the part of the program that identifies the error. For example, if function A depends on function B and the user passes input into function A that function B cannot handle, a stack trace will report an error chain from function A (the most recent call) back to function (where the error was identified). Stack traces can be as deep as they need to be, and being able to read a stack trace is necessary for finding and fixing coding errors.

## Getting an error report

One of the easiest ways to see a stack trace in Python is to divide by zero. You can do this by simply going to your command line and typing `python` and then `6/0` at the Python command line. You should get an error similar to the one below.
```
Python 3.6.1 (v3.6.1:69c0db5, Mar 21 2017, 17:54:52) [MSC v.1900 32 bit (Intel)]
 on win32
Type "help", >>> 6/0
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
ZeroDivisionError: division by zero
```
(Note: You can use the function `quit()` to get out of Python)
This doesn't show you very much information, however, as the error exists on the only level on the command line, `<stdin>`.
To get a more complicated stack trace, we need to define and call some functions. Copy and paste the code below into a new .py document (you can create one in any plain text editor).
```
def my_function():
      zero = 0
      anumber = divide(zero)
      return anumber
def divide(denominator):
    numerator = 6
    return numerator/denominator     
my_function()
```

To run this program, we navigate to the directory holding the file and run `python my_filename.py`.
You should receive the following error:
```
$ python div_by_zero.py
Traceback (most recent call last):
  File "div_by_zero.py", line 8, in <module>
    my_function()
  File "div_by_zero.py", line 3, in my_function
    anumber = divide(zero)
  File "div_by_zero.py", line 7, in divide
    return numerator/denominator
ZeroDivisionError: division by zero
```
