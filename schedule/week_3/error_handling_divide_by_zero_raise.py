# -*- coding: utf-8 -*-

d = '''This division by zero was not expected — this error is not correctable by you.
    It is an application error. If you contact the project at ... 
    we can fix it so that others do not need to experience this in the future.'''
(x,y) = (5,0)
try:
   z = x/y
except ZeroDivisionError as e:
   e.args += (d,) # tuple so cannot directly concatenate stringvalue 'd' 
   raise
