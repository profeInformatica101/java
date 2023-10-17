<?php
if (isset($_POST['submit'])) {
    $className = $_POST['className'];
    $attributes = explode(',', $_POST['attributes']);
    $methods = explode(',', $_POST['methods']);
    $generateGetSet = isset($_POST['generateGetSet']);

    header('Content-Type: text/plain');

    // Print class
    echo "class " . $className . " {\n";

    // Print attributes
    foreach ($attributes as $attribute) {
        echo "    public $" . trim($attribute) . ";\n";
    }

    // Print getters and setters
    if ($generateGetSet) {
        foreach ($attributes as $attribute) {
            // Getter
            echo "\n    public function get" . ucfirst(trim($attribute)) . "() {\n";
            echo "        return $" . "this->" . trim($attribute) . ";\n";
            echo "    }\n";

            // Setter
            echo "\n    public function set" . ucfirst(trim($attribute)) . "($" . trim($attribute) . ") {\n";
            echo "        $" . "this->" . trim($attribute) . " = $" . trim($attribute) . ";\n";
            echo "    }\n";
        }
    }

    // Print methods
    foreach ($methods as $method) {
        echo "\n    public function " . trim($method) . "() {\n";
        echo "        // TODO: Implement " . trim($method) . "\n";
        echo "    }\n";
    }

    echo "}\n";
}
?>
