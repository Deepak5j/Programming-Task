inp = input('Please enter a string: ') #'[Hello world] [Hello worldHello world] [HelloworldHelloworld]'
sub = input('Please enter the substring you wish to find: ') #'llo'
rep = input('Please enter a string to replace the given substring: ') #'@@'

def recursive_replaceAll(inp, sub, rep):
    if not inp:
        return ""
    elif inp[:len(sub)] == sub: 
        return rep + recursive_replaceAll(inp[len(sub):], sub, rep)
    else:
        return inp[0] + recursive_replaceAll(inp[1:], sub, rep)

def replace_All_By_inbuilt_function(input, sub, rep): 
    inpStr= input.replace(sub, rep) 
    return inpStr.strip() 

print('Using recursive function: ', recursive_replaceAll(inp, sub, rep))
print('Using inbuilt function: ', replace_All_By_inbuilt_function(inp, sub, rep))     
input('Enter a key to exit')

