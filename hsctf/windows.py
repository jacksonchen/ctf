import math

A = 9999999997
p = 1
thesum = 0

def calcPell(input):
  i = 0
  if (input == 0 or input == 1):
    return input
  else:
    return 2 * calcPell(input-1) + calcPell(input-2)

s1 = calcPell(p)
s2 = calcPell(p+1)
while (1 < 2):
  double = 2*s1*s2
  diffsq = s2*s2-s1*s1
  print "Pell: " + str(s1)
  if (double > diffsq):
    if (double > A):
      break
    thesum += diffsq
    print diffsq
  else:
    if (diffsq > A):
      break
    thesum += double
    print double
  p += 1
  s1 = calcPell(p)
  s2 = calcPell(p+1)

print "THE SUM: " + str(thesum)
