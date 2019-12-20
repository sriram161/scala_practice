from xml.dom.minidom import parse
from pprint import pprint
import re

xml_doc = parse("input.xml")
#pprint(xml_doc)
#pprint(dir(xml_doc))

def to_dict(root):
    result = {}
    stack = []
    def update_result(value):
        nonlocal stack, result
        temp = result
        for _key in stack:
            val = temp.get(_key)
            if val is None and stack[-1] != _key:
                temp[_key] = dict()
                temp = temp.get(_key)
            elif val is None and stack[-1] == _key:
                temp[_key] = value
            elif type(val) is dict:
                temp = val


    def process_node(parent):
        nonlocal stack, result
        if not re.search("^#", parent.nodeName):
            stack.append(parent.nodeName)
        if parent.hasChildNodes():
            for child in parent.childNodes:
                process_node(child)
        elif not re.match("^\s*$", parent.nodeValue):
            update_result(parent.nodeValue)
            print(stack)
        if not re.search("^#", parent.nodeName):
            stack.pop()
    process_node(root)
    return result
                

pprint(to_dict(xml_doc))
    
# xml_doc.hasChildNodes()
# xml_doc.childNodes
# xml_doc.nodeName
# xml_doc.nodeValue
