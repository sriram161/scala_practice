'''Tasks:
1) find multiples of 3 or 5 under 10.
2) Find sum of all the multiples found.'''

import abc
import logging
logger = logging.getLogger(__name__)  #step1: create logger object

#step2: create handler object and configure (formatter and level for channel handler)
console_stream = logging.StreamHandler()
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
console_stream.setFormatter(formatter)
console_stream.setLevel(logging.DEBUG)

#step3: config logger object by adding channel handler and set logging level
logger.addHandler(console_stream)
logger.setLevel(logging.DEBUG)

class FactorComputeMachineInterface(object):
    ''' Interface for factor's multiples computing machine under a given
    upperlimit.'''

    __metaclass__ = abc.ABCMeta

    @abc.abstractmethod
    def add_base_factor(self, value_object):
        raise NotImplementedError("Implement add factors to a container.")

    @abc.abstractmethod
    def add_super_limit(self, value_object):
        raise NotImplementedError("Implement to set upperlimit values for \
                                  computing machine")

    @abc.abstractmethod
    def compute_on_multiples(self):
        raise NotImplementedError("Implement to processs compute operation \
                                  for a operator")

    @abc.abstractmethod
    def get_result(self):
        raise NotImplementedError("Implement to return value after computation")

class ViewFactorComputeMachineParameters(object):
    ''' View interface for factory compute machine parameters'''

    __metaclass__ = abc.ABCMeta

    @abc.abstractmethod
    def get_base_factors(self):
        raise NotImplementedError("Implement add factors to a container.")

    @abc.abstractmethod
    def get_super_limit(self):
        raise NotImplementedError("Implement to set upperlimit values for \
                                  computing machine")

class ComputeInterface(object):
    ''' Interface for strategy pattern used to decouple varing behaviour of
       compute functionality which can be addition, multiplication or substarction
    '''

    __metaclass__ = abc.ABCMeta

    @abc.abstractmethod
    def compute(self, *args):
        raise NotImplementedError("Please implement this method for computing \
                                  a way for using in factor computer")

class ComputeSum(ComputeInterface):
    def compute(self, *args):
        return sum(args)

class ComputeMultiplication(ComputeInterface):
    def compute(self, *args):
        return reduce(lambda x,y: x*y, args)

class IntFactorComputer(FactorComputeMachineInterface, ViewFactorComputeMachineParameters):
    ''' Int factor values compute class using interface of FactorComputeMachine
    '''

    def __init__(self):
        self.__factors = []
        self.__limit = None
        self.__results = 0
        self.__compute_object = None
        self.__mulitple_finder = lambda value,limit : (value*i for i in range(1,limit) if value*i < limit)

    def add_base_factor(self, value_object):
        self.__factors.append(value_object)
        logger.info("Added Factor! {0}".format(value_object))

    def add_super_limit(self, value_object):
        self.__limit = value_object

    def compute_on_multiples(self):
        for value in self.get_base_factors():
            logger.info("Computing!!!")
            self.__results += self.__compute_object.compute( *self.__mulitple_finder(value, self.get_super_limit()))
        logger.info("Computed!!!")

    def get_result(self):
        return self.__results

    def get_base_factors(self):
        if self.__factors:
            return self.__factors
        logger.info("Please add factors to the Machine!!!")

    def get_super_limit(self):
        if self.__limit:
            return self.__limit
        logger.info("Please add super limit value!!!")

    def set_compute_object(self, obj):
        self.__compute_object = obj

if(__name__ == "__main__"):
    
    x = IntFactorComputer()
    x.add_super_limit(10)
    x.add_base_factor(3)
    x.add_base_factor(5)
    x.set_compute_object(ComputeSum()) #Dependency injection
    x.set_compute_object(ComputeMultiplication())

    x.compute_on_multiples()

    logger.info(x.get_super_limit())
    logger.info(x.get_base_factors())
    logger.info(x.get_result())
