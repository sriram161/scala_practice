from itertools import takewhile

def fib_generator():
    __prime_1 = 0
    __prime_2 = 1
    while True:
        next_term = __prime_1 + __prime_2
        __prime_1,__prime_2 = __prime_2,next_term
        yield next_term
       
def fib_generator_limited(N = None):
    if(type(N) in [int,float]):
        for ele in takewhile(lambda num:num <= int(N),fib_generator()):
            yield ele

def sum_of_even_fib_limited(N = None):
    fib_sum = 0
    for ele in fib_generator_limited(N):
	if(ele%2 == 0):
		fib_sum = fib_sum + ele
    return fib_sum
                   
if(__name__ == "__main__"):
    x1 = fib_generator_limited(N = 10)
    print x1

#microsoft ui automation
#metaclass
#unittest module