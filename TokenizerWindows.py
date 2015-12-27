__author__ = 'Justin Purcell'

import subprocess  

def runFile(f):
    p = subprocess.Popen('java -Dfile.encoding=UTF-8 -classpath PATH/TO/kuromoji-0.7.7.jar QUALIFIED/CLASSNAME/OF/TokenizerEx '+f,stdout=subprocess.PIPE)
    while p.poll() is None:
        l = p.stdout.readline()
        if l: print l.decode('utf-8')
    p.kill()
    
def main():
    runFile('PATH/TO/input.txt')

if __name__=='__main__':
    print 'Running kuromoji Tokenizer for Windows...'
    main()
    print 'Finished'