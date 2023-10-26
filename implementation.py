# -*- coding: utf-8 -*-
"""
Created on Fri Jun 16 14:24:18 2023

@author: MAZHARUL ISLAM
"""
import random

    
p = 11
q = 7
m = p * q
msg = 9
msg_id = msg - 1
message = [3,3,3]
encrypted = []
#r = random.randint(0,m)
r = 0

print(r)
 

secret_keys = [r,m,q]
shared_keys = p

#encryption

def concat(p,q):
    s1 = str(p)
    s2 = str(q)
     
   # Concatenate both strings    
    s = s1 + s2
     
   # Convert the concatenated string
   # to integer
    pq = int(s)
     
   # return the formed integer
    return pq

pq = concat(p, q)
print(pq)
print("message : ", message[0])
for r in range (pq):
    y = (message[0] + r * pq) % 77
    

#y = 25

print(y)

d = pow(y,1,p)
print(d)
 
