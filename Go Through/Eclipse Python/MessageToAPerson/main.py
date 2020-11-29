# nobodyward@gmail.com  mazdasp33d
import smtplib
from tkinter import Tk, Label, Button



def sendingEmail1():
#    smtpObj = smtplib.SMTP('smtp.gmail.com', 587)
    print("This is before");
    
#     smtpObj = smtplib.SMTP_SSL('secure.emailsrvr.com', 465)
    smtpObj = smtplib.SMTP('secure.emailsrvr.com', 25)
    print("This is it")
    print(smtpObj.ehlo())
    print(type(smtpObj))
#     print(smtpObj.starttls())
    print(smtpObj.login('jacob@thewardsweb.com', 'mazdasp33d'))
#     smtpObj.data("Tis the message")
#   Sending the mail test
    print(smtpObj.sendmail('jacob@thewardsweb.com', 'jacob@thewardsweb.com', 'Subject: So long.\nThis is a test email'))
    print(smtpObj.sendmail('jacob@thewardsweb.com', 'masterward14@gmail.com', 'Subject: So long.\nThis is a test email'))
#     print("This is sent")
#    smtpObj.login('nobodyward@gmail.com', 'mazdasp33d')
#    smtpObj.sendmail('nobodyward@gmail.com', 'masterward14@gmail.com', 'Subject: So long.\nThis is a test email')
    smtpObj.quit()

    
def main():
    pr = print
    pr("Thank you for trying this out.")
    pr("I promise if I was going to hack you I would have done it by now.");
    pr("I have written a note but only for one person.")
    pr("Do this while no one is around you as shoulder surfing is a thing.")
    pr("Answer some questions to make sure it is really you")
    
#     top = tkinter.Tk();
#     w = tkinter.Text("This is the message I think")
#     top.mainloop();
# main();


class MyFirstGUI:

    def __init__(self, master):
        self.master = master
        master.title("Test Program")
        
        self.label = Label(master, text="This is our first gui")
        self.label.pack()
        
        self.greet_button = Button(master, text="Greet", command=self.greet)
        self.greet_button.pack()
        
        self.close_button = Button(master, text="Close", command=master.quit);
        self.close_button.pack()
    
    def greet(self):
        print("greetings")
        

root = Tk()
my_GUI = MyFirstGUI(root)
root.mainloop()
        
