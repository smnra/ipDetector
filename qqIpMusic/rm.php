<?php
foreach(glob('*.json') as $file){
    unlink($file);
}