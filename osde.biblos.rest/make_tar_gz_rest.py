# -*- coding: utf-8 -*-
import os
import tarfile
from pip._vendor.requests.api import patch
from docutils.parsers.rst.directives import path

props_separator = '='
props = {}
manifest = {}
manifest_separator = ':'

"""
# I named your file conf and stored it 
# in the same directory as the script

with open( os.path.join('.','conf', 'Language-ext.properties') ) as f:

    for line in f:
        if props_separator in line:

            # Find the name and value by splitting the string
            name, value = line.split(props_separator, 1)

            # Assign key value pair to dict
            # strip() removes white space from the ends of strings
            props[name.strip()] = value.strip()
"""
         
def keyValueFromFile( file, separator, keyValueStore):
    
    with open( file ) as f:
        
        for line in f:
            if separator in line:
    
                name, value = line.split(separator, 1)

                keyValueStore[name.strip()] = value.strip()

keyValueFromFile( os.path.join('.', 'MANIFEST.MF'), manifest_separator, manifest)

lang_properties = os.path.join('.','conf', 'Language-ext.properties')

if os.path.exists( lang_properties ):
    keyValueFromFile( lang_properties, props_separator, props)
    
def empaquetarFile( path_to_file, file_name ):
    
    if os.path.exists( os.path.join( path_to_file, file_name ) ):
        empaquetador.add( os.path.join( path_to_file, file_name ), arcname= plugin_name_version + "/" + plugin_name +"/"+ file_name )    
    
def empaquetarDir( path_to_file, dir_target ):
    
    if os.path.exists( path_to_file ):
        empaquetador.add( path_to_file, arcname= plugin_name_version + "/" + plugin_name +'/'+ dir_target )    

dir_out = os.path.join( '.', 'plugin_out')

if not os.path.exists(dir_out):
    os.mkdir(dir_out)

print manifest
print 'Ingresá 1 si la nueva versión es incompatible con la anterior'
print 'Ingresá 2 si la nueva versión agrega nueva funcionalidad'
print 'Ingresa 3 si la nueva versión es un arreglo de bug o es un cambio menor'
#print 'Ingresá 4 si la nueva versión no modifica el número de versión'

op = int( raw_input("Versión actual del plugin "+ manifest['Plugin-Version'] +": ") )

try:
    smajor, sminor, spatch = manifest['Plugin-Version'].split('.')
except:
    smajor, sminor = manifest['Plugin-Version'].split('.')
    spatch = 0

major = int(smajor)
minor = int(sminor)
patch = int(spatch )

if op == 1:
    
    major = major + 1
    minor = 0
    patch = 0
    
elif op == 2:
    
    minor = minor + 1
    patch = 0
    
elif op == 3:
    
    patch = patch + 1

version = '.'.join([ str(major), str(minor), str(patch) ])

if op < 4:
    
    manifest['Plugin-Version'] = version
    # save manifest.mf
    f = open( os.path.join( '.', 'MANIFEST.MF' ), "w" )
    
    for k, v in manifest.items():
        
        f.write( k +': '+ v +'\n' )
    f.close()

plugin_name         = os.path.split( os.getcwd() )[-1]
plugin_name_version = plugin_name +'_'+ version

plugin_name_split = plugin_name.split('.')

last_name = '-'.join(plugin_name_split[-2:])

print last_name

if 'com.dotcms.repackage.javax.portlet.title.landing-pages.'+ last_name in props:
    
    plugin_name_version = props['com.dotcms.repackage.javax.portlet.title.landing-pages.'+ last_name].replace(" ", "-") +'_'+ version
    
elif 'com.dotcms.repackage.javax.portlet.title.'+ last_name in props:
    
    plugin_name_version = props['com.dotcms.repackage.javax.portlet.title.'+ last_name].replace(" ", "-") +'_'+ version

elif 'javax.portlet.title.'+ last_name in props:
    
    plugin_name_version = props['javax.portlet.title.'+ last_name].replace(" ", "-") +'_'+ version

file_name = plugin_name_version +".tar.gz"

print 'empaquetando plugin en', file_name

empaquetador = tarfile.open( os.path.join( dir_out, file_name ), "w:gz")

empaquetarDir( os.path.join( '.', 'src'), 'src' )
empaquetarDir( os.path.join( '.', 'lib'), 'lib' )
empaquetarDir( os.path.join( '.', 'ROOT'), 'ROOT')
empaquetarFile( '.', 'build.xml' )
empaquetarFile( '.', 'MANIFEST.MF' )
empaquetarFile( '.', 'README.txt' )

empaquetador.close()

print 'listo'

