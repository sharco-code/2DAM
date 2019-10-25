hour = int(input("Starting time (hours): "))
mins = int(input("Starting time (minutes): "))
dura = int(input("Event duration (minutes): "))

a = hour * 60 + mins + dura

print(round(a//60,0),":",a%60,sep="")