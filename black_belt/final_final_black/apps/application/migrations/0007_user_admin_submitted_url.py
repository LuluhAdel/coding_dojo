# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-09-24 16:02
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('application', '0006_feedback_read'),
    ]

    operations = [
        migrations.AddField(
            model_name='user_admin',
            name='submitted_URL',
            field=models.TextField(default=''),
            preserve_default=False,
        ),
    ]
