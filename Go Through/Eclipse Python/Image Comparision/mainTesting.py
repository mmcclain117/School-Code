import sys

def main():
    print("Welcome to the Main tester\n")
    print("Choose the method of merging:")
    print("1. Merge two files")
    print("2. Merger all of 1 name")
    print("3. Batch merge in a folder")
    meth = input(); # Method
    print(meth)
    if(meth == '1'):
        print("Glad you are merging only 2 files.")
        pdfmerge()
    elif(meth == '2'):
        print("Wow really want get this person's PDF")
    elif(meth == '3'):
        print("That's the way to go. Lets be productive")
    else:
        print("That doesn't work now")
        
def pdfmerge():
    print("We made it to another method")
main();