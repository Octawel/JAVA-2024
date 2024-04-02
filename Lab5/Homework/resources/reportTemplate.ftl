<!DOCTYPE html>
<html>
<head>
    <title>Master Directory Report</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .folder { margin-top: 20px; }
        .folder h2 { color: #333; }
        .file { margin-left: 20px; }
        .file-info { font-size: 0.9em; color: #666; }
    </style>
</head>
<body>
    <h1>Master Directory Report</h1>
    <#list folders as folder>
        <div class="folder">
            <h2>Folder: ${folder.name}</h2>
            <#list folder.files as file>
                <div class="file">
                    File: ${file.name}
                    <div class="file-info">
                        Size: ${file.size} bytes, Last Modified: ${file.lastModified}
                    </div>
                </div>
            </#list>
        </div>
    </#list>
</body>
</html>
