# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-09-25 08:38
from __future__ import unicode_literals

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('application', '0008_auto_20190924_1912'),
    ]

    operations = [
        migrations.RenameField(
            model_name='files',
            old_name='respone',
            new_name='name',
        ),
        migrations.RenameField(
            model_name='files',
            old_name='user_id',
            new_name='phoneNo',
        ),
    ]
