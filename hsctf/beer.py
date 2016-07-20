minimum = 2506000000000000000
minsq = 1583035060
sq = 2506000001189203600
mintri = 2238749651
tri = 2506000001045685726

def nextSq(minsq):
  minsq += 1
  return minsq

def nextTri(mintri):
  mintri += 1
  return mintri

# def main(minsq, mintri):
#   if (minsq * minsq) > (mintri * (mintri + 1) / 2):
#     nextTri(mintri)
#     print "minsq: " + str(minsq) + " mintri: " + str(mintri)
#     main(minsq, mintri)
#   elif (mintri * (mintri + 1) / 2) > (minsq * minsq):
#     nextSq(minsq)
#     print "minsq: " + str(minsq) + " mintri: " + str(mintri)
#     main(minsq, mintri)
#   else:
#     return minsq * minsq

# print main(1583035060, 2238749651)

while ((minsq * minsq) != (mintri * (mintri + 1) / 2)):
  if (minsq * minsq) > (mintri * (mintri + 1) / 2):
    mintri = nextTri(mintri)
  else:
    minsq = nextSq(minsq)

print (minsq * minsq)
