import re

arr = []
occur = []
with open("markovhaystack.txt", "r") as f:
  for line in f:
    if line not in arr:
      arr.append(line)
      occur.append(1)
    else:
      occur[arr.index(line)] += 1

f = open("unique.txt","w")
for i in range(len(occur)):
  if occur[i] == 1:
    # matchObj = re.search("comput|Comput|machine|Machine|AI|German|Millenium|analytical|engine", arr[i])
    # if not matchObj:
    f.write(arr[i])
f.close()
