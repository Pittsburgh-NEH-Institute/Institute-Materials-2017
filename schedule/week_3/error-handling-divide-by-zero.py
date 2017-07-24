(x,y) = (5,0)
try:
   z = x/y
except ZeroDivisionError:
   print "divide by zero. We need to recover. Maybe ask the user for a better value."
# Depending on if we can recover or not: do what is needed to nicely exit or take receovery actions
