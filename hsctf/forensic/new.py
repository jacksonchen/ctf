import re

with open("unique.txt", "r") as f:
  for line in f:
    matchObj = re.search("comput|Comput|machine|Machine|AI|German|Millenium|analytical|engine|Europe|female|engineer|ancient|philosophy|Philosophy|programming|theory|intelligence|Research|research|Alan|Codes|AP|women|WWII", line)
    if not matchObj:
      print line
